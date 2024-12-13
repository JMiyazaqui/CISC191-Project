public class Elephant extends Animal {
    public Elephant() {
        super();
    }

    /**
     * Specific behavior for an Elephant to trumpet.
     */
    public void trumpet() {
        System.out.println("The elephant trumpets loudly with its trunk!");
    }

    @Override
    public String toString() {
        return "Elephant (" + getHealthStatus() + ")";
    }
}
