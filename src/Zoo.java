import java.io.*;
import java.util.*;

public class Zoo {
    private List<Animal> animals;

    public Zoo() {
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public Animal getAnimal(int index) {
        return (index >= 0 && index < animals.size()) ? animals.get(index) : null;
    }

    public void feedAllAnimals() {
        for (Animal animal : animals) {
            animal.feed();
        }
    }

    public void saveToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Animal animal : animals) {
                writer.write(animal.getType() + "," + animal.getName() + "," + animal.getHealthStatus());
                writer.newLine();
            }
        }
    }

    public void loadFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Animal animal;
                switch (parts[0]) {
                    case "Lion":
                        animal = new Lion(parts[1], parts[2]);
                        break;
                    case "Penguin":
                        animal = new Penguin(parts[1], parts[2]);
                        break;
                    case "Elephant":
                        animal = new Elephant(parts[1], parts[2]);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown animal type: " + parts[0]);
                }
                animals.add(animal);
            }
        }
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}