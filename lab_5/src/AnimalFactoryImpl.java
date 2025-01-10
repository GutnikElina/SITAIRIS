import Models.Animal;
import Models.Cat;
import Models.Dog;

public class AnimalFactoryImpl implements AnimalFactory {
    @Override
    public Animal createAnimal(String name, double careCost) {
        return Math.random() < 0.5 ? new Dog(name, careCost) : new Cat(name, careCost);
    }
}