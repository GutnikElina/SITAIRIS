package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Animal{

    private int id;
    private String name;
    private double careCost;

    public Animal(String name, double careCost) {
        this.name = name;
        this.careCost = careCost;
    }
}