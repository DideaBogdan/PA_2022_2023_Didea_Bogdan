import javax.swing.*;

import java.awt.*;

import static javax.swing.SwingConstants.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components

        controlPanel = new ControlPanel(this);
        configPanel = new ConfigPanel(this);
        canvas = new DrawingPanel(this);
 //...TODO

        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        add(configPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER); //this is BorderLayout.CENTER
        add(controlPanel, BorderLayout.SOUTH);
 //...TODO

        //invoke the layout manager
        pack();
    }
}
