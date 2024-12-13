import java.util.List;
import java.util.ArrayList;

public class Zoo {
    private List<Animal> animals;

    public Zoo() {
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public boolean feedAnimal(String animalType) {
        for (Animal animal : animals) {
            if (animal.toString().contains(animalType)) {
                animal.feed();
                return true; // Successfully fed the animal
            }
        }
        return false; // Animal not found
    }
}
