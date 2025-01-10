import Models.Animal;

public interface AnimalFactory {
    Animal createAnimal(String name, double careCost); // изменено
}
