public class Penguin extends Animal {
    public Penguin(String name, String healthStatus) {
        super(name, healthStatus);
    }

    @Override
    public String getType() {
        return "Penguin";
    }
}