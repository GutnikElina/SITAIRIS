import Models.Animal;

import java.util.List;

public interface AnimalPersistenceAdapter {
    List<Animal> loadAnimals();
    void saveAnimals(List<Animal> animals);
    void saveAdoptedAnimals(List<Animal> adoptedAnimals);
}
