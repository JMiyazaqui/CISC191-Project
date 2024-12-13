public class Penguin extends Animal {
    public Penguin() {
        super();
    }

    /**
     * Specific behavior for a Penguin to swim.
     */
    public void swim() {
        System.out.println("The penguin happily swims in the water!");
    }

    @Override
    public String toString() {
        return "Penguin (" + getHealthStatus() + ")";
    }
}