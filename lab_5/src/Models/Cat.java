package Models;

public class Cat implements Animal {

    private String name;
    private double careCost;

    public Cat(String name, double careCost) {
        this.name = name;
        this.careCost = careCost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return "Кошка";
    }

    @Override
    public double getCareCost() {
        return careCost;
    }

    @Override
    public void displayInfo() {
        System.out.println("Кошка: " + name + ", Стоимость содержания: " + careCost);
    }
}