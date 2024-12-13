import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZooGUI {
    private Zoo zoo;
    private JFrame frame;
    private JTextArea animalListArea;

    public ZooGUI() {
        zoo = new Zoo();
        frame = new JFrame("Zoo Management Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        animalListArea = new JTextArea();
        animalListArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(animalListArea);

        JButton addButton = new JButton("Add Animal");
        JButton feedButton = new JButton("Feed Animal");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = {"Lion", "Penguin", "Elephant"};
                String animalType = (String) JOptionPane.showInputDialog(
                    frame,
                    "Select an animal to add:",
                    "Add Animal",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]
                );

                if (animalType != null) {
                    switch (animalType) {
                        case "Lion" -> zoo.addAnimal(new Lion());
                        case "Penguin" -> zoo.addAnimal(new Penguin());
                        case "Elephant" -> zoo.addAnimal(new Elephant());
                    }
                    refreshAnimalList();
                }
            }
        });

        feedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String animalType = JOptionPane.showInputDialog(
                    frame,
                    "Enter the type of animal to feed (e.g., Lion, Elephant, Penguin):",
                    "Feed Animal",
                    JOptionPane.PLAIN_MESSAGE
                );

                if (animalType != null && !animalType.trim().isEmpty()) {
                    boolean success = zoo.feedAnimal(animalType);
                    if (success) {
                        JOptionPane.showMessageDialog(frame, animalType + " has been fed and is now healthy!");
                    } else {
                        JOptionPane.showMessageDialog(frame, "No " + animalType + " found in the zoo!");
                    }

                    // Refresh the animal list display
                    refreshAnimalList();
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(feedButton);

        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void refreshAnimalList() {
        StringBuilder animalListText = new StringBuilder("Animals in the zoo:\n");
        for (Animal animal : zoo.getAnimals()) {
            animalListText.append("- ").append(animal).append("\n");
        }
        animalListArea.setText(animalListText.toString());
    }

    public static void main(String[] args) {
        new ZooGUI();
    }
}
