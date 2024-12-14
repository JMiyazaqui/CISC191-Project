import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class ZooGUI {
    private Zoo zoo;
    private JFrame frame;
    private JTextArea displayArea;

    public ZooGUI() {
        zoo = new Zoo();
        frame = new JFrame("Zoo Management Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        frame.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        JButton addLionButton = new JButton("Add Lion");
        JButton addPenguinButton = new JButton("Add Penguin");
        JButton addElephantButton = new JButton("Add Elephant");
        JButton feedButton = new JButton("Feed Animals");
        JButton saveButton = new JButton("Save");
        JButton loadButton = new JButton("Load");

        panel.add(addLionButton);
        panel.add(addPenguinButton);
        panel.add(addElephantButton);
        panel.add(feedButton);
        panel.add(saveButton);
        panel.add(loadButton);
        frame.add(panel, BorderLayout.SOUTH);

        addLionButton.addActionListener(e -> addAnimal(new Lion("Lion" + (zoo.getAnimals().size() + 1), "Hungry")));
        addPenguinButton.addActionListener(e -> addAnimal(new Penguin("Penguin" + (zoo.getAnimals().size() + 1), "Hungry")));
        addElephantButton.addActionListener(e -> addAnimal(new Elephant("Elephant" + (zoo.getAnimals().size() + 1), "Hungry")));
        feedButton.addActionListener(e -> {
            zoo.feedAllAnimals();
            updateDisplay();
        });
        saveButton.addActionListener(e -> {
            try {
                zoo.saveToFile("zoo.txt");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error saving file: " + ex.getMessage());
            }
        });
        loadButton.addActionListener(e -> {
            try {
                zoo.loadFromFile("zoo.txt");
                updateDisplay();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error loading file: " + ex.getMessage());
            }
        });

        frame.setVisible(true);
    }

    private void addAnimal(Animal animal) {
        zoo.addAnimal(animal);
        updateDisplay();
    }

    private void updateDisplay() {
        StringBuilder builder = new StringBuilder();
        for (Animal animal : zoo.getAnimals()) {
            builder.append(animal).append("\n");
        }
        displayArea.setText(builder.toString());
    }

    public static void main(String[] args) {
        new ZooGUI();
    }
}