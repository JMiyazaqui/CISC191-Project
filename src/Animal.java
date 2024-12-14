public abstract class Animal {
    private String name;
    private String healthStatus;

    public Animal(String name, String healthStatus) {
        this.name = name;
        this.healthStatus = healthStatus;
    }

    public String getName() {
        return name;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void feed() {
        this.healthStatus = "Healthy";
    }

    public abstract String getType();

    @Override
    public String toString() {
        return getType() + " (" + healthStatus + ")";
    }
}