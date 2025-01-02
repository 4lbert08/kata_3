package software.ulpgc.kata_3.app.windows;

import software.ulpgc.kata_3.arquitecture.control.Command;
import software.ulpgc.kata_3.arquitecture.view.SelectBarchartDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private final Map<String, Command> commands;
    private JfreeBarchartDisplay barchartDisplay;
    private  SelectBarchartDialog selectBarchartDialog;

    public MainFrame() {
        commands = new HashMap<>();
        setTitle("Kata_3");
        setSize(1100, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setIconImage(getIcon("C:\\Users\\User\\Universidad\\3º\\IS2\\katas\\kata3\\albertosaurusSkull.jpeg"));
        add(BorderLayout.NORTH, toolbar());
        add(barchartDisplay = statisticPanel());
    }

    public JfreeBarchartDisplay getBarchartDisplay() {
        return barchartDisplay;
    }

    public void put(String key, Command value) {
        commands.put(key, value);
    }

    public SelectBarchartDialog getSelectBarchartDialog() {
        return selectBarchartDialog;
    }

    private JfreeBarchartDisplay statisticPanel() {
        return new JfreeBarchartDisplay();
    }

    private Component toolbar() {
        JPanel panel = new JPanel();
        panel.add(selector());
        return panel;
    }

    private Component selector() {
        JComboBox comboBox = new JComboBox<>();
        comboBox.addItem("Dinosaurs Diets");
        comboBox.addItem("Dinosaurs Periods");
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (commands.containsKey("select")){
                    commands.get("select").execute();
                }
            }
        });
        selectBarchartDialog = new SelectBarchartDialog() {
            @Override
            public int getSelection() {
                return comboBox.getSelectedIndex();
            }
        };
        return comboBox;
    }

    private Image getIcon(String path) {
        return new ImageIcon(path).getImage();
    }
}
