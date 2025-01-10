package Models;

public class Dog implements Animal {
    private String name;
    private double careCost;

    public Dog(String name, double careCost) {
        this.name = name;
        this.careCost = careCost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return "Собака";
    }

    @Override
    public double getCareCost() {
        return careCost;
    }

    @Override
    public void displayInfo() {
        System.out.println("Собака: " + name + ", Стоимость содержания: " + careCost);
    }
}