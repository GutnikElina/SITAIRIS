package Patterns;

import Entity.Animal;

public class AnimalFactory {
    public static Animal createAnimal(String name, double careCost) {
        Animal animal = new Animal(name, careCost);
        return animal;
    }
}

