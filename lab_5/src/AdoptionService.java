import Models.Animal;

import java.util.List;

public interface AdoptionService {
    void adoptAnimal(Animal animal);
    void showAdoptedAnimals();
    void addAnimal(Animal animal);
    double getTotalCareCost();
    List<Animal> getAllAnimals();
    List<Animal> getAdoptedAnimals();
    String generateReceipt();
}