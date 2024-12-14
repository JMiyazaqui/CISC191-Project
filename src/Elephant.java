public class Elephant extends Animal {
    public Elephant(String name, String healthStatus) {
        super(name, healthStatus);
    }

    public void trumpet() {
        System.out.println("The elephant trumpets loudly with its trunk!");
    }

    @Override
    public String getType() {
        return "Elephant";
    }
}