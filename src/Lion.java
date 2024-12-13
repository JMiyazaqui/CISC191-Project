
public class Lion extends Animal {
    public Lion() {
        super();
    }

    /**
     * Specific behavior for a Lion to roar.
     */
    public void roar() {
        System.out.println("The lion lets out a mighty roar!");
    }

    @Override
    public String toString() {
        return "Lion (" + getHealthStatus() + ")";
    }
}
