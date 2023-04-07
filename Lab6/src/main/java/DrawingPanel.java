import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.PrimitiveIterator;
import java.util.Random;

public class DrawingPanel extends JPanel implements MouseListener {
    final MainFrame frame;
    final static int W = 800, H = 600;
    private int numVertices;
    private double edgeProbability;
    private int[] x, y;
    private ArrayList<Line> gameLines;
    private ArrayList<Line> playerLines1;
    private ArrayList<Line> playerLines2;
    boolean turn ;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the tools needed to draw in the image

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        initPanel();
        createBoard();
        addMouseListener((MouseListener) this);
    }

    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //TODO...
                repaint();
            }
        });
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);
    }

    final void createBoard() {
        numVertices = (Integer) frame.configPanel.dotsSpinner.getValue();
        edgeProbability = (Double) frame.configPanel.linesCombo.getSelectedItem();
        gameLines = new ArrayList<>();
        playerLines1 = new ArrayList<>();
        playerLines2 = new ArrayList<>();
        turn = true;
        createOffscreenImage();
        createVertices();
        drawLines();
        drawVertices();
        repaint();
    }

    private void createVertices() {
        int x0 = W / 2;
        int y0 = H / 2; //middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / numVertices; // the angle
        x = new int[numVertices];
        y = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
        }
    }

    private void drawLines() {

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (i != j) {
                    Random rand = new Random();
                    boolean flag = rand.nextDouble() < edgeProbability;
                    if (flag) {
                        graphics.setColor(Color.GRAY);
                        if(!gameLines.contains(new Line(x[j], y[j], x[i], y[i]))){
                            gameLines.add(new Line(x[i], y[i], x[j], y[j]));
                            graphics.drawLine(x[i], y[i], x[j], y[j]);
                        }

                    }
                }
            }
        }
        System.out.println(gameLines);



    }

    private void drawPlayerLines() {
        graphics.setColor(Color.GRAY);
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                graphics.drawLine(x[i], y[i], x[j], y[j]);
            }
        }
    }


    private void drawVertices() {
        graphics.setColor(Color.BLACK);
        for (int i = 0; i < numVertices; i++) {
            graphics.fillOval(x[i] - 5, y[i] - 5, 10, 10);
        }
    }

    public void mouseClicked(MouseEvent e) {
    }


    @Override
    public void mousePressed(MouseEvent e) {

        int x = e.getX();
        int y = e.getY();
        int cx0=0, cy0=0, cx1=0, cy1=0;
        for (Line gameLine : gameLines) {
            double distance = Math.abs((gameLine.getX1() - gameLine.getX0()) * (gameLine.getY0() - y) - (gameLine.getX0() - x) * (gameLine.getY1() - gameLine.getY0())) / Math.sqrt(Math.pow(gameLine.getX1() - gameLine.getX0(), 2) + Math.pow(gameLine.getY1() - gameLine.getY0(), 2));
            if (0 <= distance && distance <= 5) {
                cx0 = gameLine.getX0();
                cx1 = gameLine.getX1();
                cy0 = gameLine.getY0();
                cy1 = gameLine.getY1();
            }
        }
        if (playerLines1.contains(new Line(cx0,cy0,cx1, cy1)) || playerLines1.contains(new Line(cx0,cy0,cx1, cy1))){
            return;
        }

        if (turn) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (!playerLines2.contains(new Line(cx0, cy0, cx1, cy1)) && gameLines.contains(new Line(cx0, cy0, cx1, cy1))) {
                        playerLines1.add(new Line(cx0, cy0, cx1, cy1));
                        graphics.setColor(Color.BLUE);
                        graphics.drawLine(cx0, cy0, cx1, cy1);
                        turn = false;
                    }
                }
            }
        } else {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (!playerLines1.contains(new Line(cx0, cy0, cx1, cy1)) && gameLines.contains(new Line(cx0, cy0, cx1, cy1))) {
                        playerLines2.add(new Line(cx0, cy0, cx1, cy1));
                        graphics.setColor(Color.RED);
                        graphics.drawLine(cx0, cy0, cx1, cy1);
                        turn = true;
                    }
                }
            }

        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    @Override
    public void update(Graphics g) { } //No need for update

    //Draw the offscreen image, using the original graphics
    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }
    public void saveGame(String fileName) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            System.out.println("Game saved as " + fileName);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

}

