public class Animal {
    private String healthStatus;

    public Animal() {
        this.healthStatus = "Hungry"; // Default state
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void feed() {
        healthStatus = "Healthy";
    }

    @Override
    public String toString() {
        return "Animal (" + healthStatus + ")";
    }
}
