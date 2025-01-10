import Models.Animal;

import java.util.List;

public class AnimalShelter {

    private static AnimalShelter instance;
    private AnimalPersistenceAdapter animalPersistenceAdapter;
    private AdoptionService adoptionService;

    private AnimalShelter(String filePathAll, String filePathAdopted) {
        this.animalPersistenceAdapter = new XmlAnimalAdapter(filePathAll, filePathAdopted);
        List<Animal> animals = animalPersistenceAdapter.loadAnimals();
        this.adoptionService = new AdoptionServiceImpl(this);
        animals.forEach(adoptionService::addAnimal);
    }

    public static synchronized AnimalShelter getInstance(String filePathAll, String filePathAdopted) {
        if (instance == null) {
            instance = new AnimalShelter(filePathAll, filePathAdopted);
        }
        return instance;
    }

    public AdoptionService getAdoptionService() {
        return adoptionService;
    }

    public void saveAnimals() {
        animalPersistenceAdapter.saveAnimals(adoptionService.getAllAnimals());
        animalPersistenceAdapter.saveAdoptedAnimals(adoptionService.getAdoptedAnimals());
    }
}
