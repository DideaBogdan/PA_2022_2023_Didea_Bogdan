import jdk.internal.icu.util.CodePointMap;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createButton;
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //create the label and the spinner
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(8, 3, 100, 1));
        linesLabel = new JLabel("Line probability");
        linesCombo = new JComboBox();
        linesCombo.addItem(1.0);
        linesCombo.addItem(0.9);
        linesCombo.addItem(0.8);
        linesCombo.addItem(0.7);
        linesCombo.addItem(0.6);
        linesCombo.addItem(0.5);
        linesCombo.addItem(0.4);
        linesCombo.addItem(0.3);
        linesCombo.addItem(0.2);
        linesCombo.addItem(0.1);
        createButton = new JButton("Create new game");
        //create the rest of the components
        add(dotsLabel); //JPanel uses FlowLayout by default
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(createButton);

        createButton.addActionListener(this::createNewGame);
    }

    private void createNewGame(ActionEvent e){
        frame.canvas.createBoard();
    }
}

