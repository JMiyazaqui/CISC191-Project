public class Lion extends Animal {
    public Lion(String name, String healthStatus) {
        super(name, healthStatus);
    }

    @Override
    public String getType() {
        return "Lion";
    }
}