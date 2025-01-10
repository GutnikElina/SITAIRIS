import Models.Animal;

import java.util.ArrayList;
import java.util.List;

public class AdoptionServiceImpl implements AdoptionService {

    private List<Animal> adoptedAnimals = new ArrayList<>();
    private List<Animal> allAnimals = new ArrayList<>();
    private AnimalShelter shelter;

    public AdoptionServiceImpl(AnimalShelter shelter) {
        this.shelter = shelter;
    }

    @Override
    public void adoptAnimal(Animal animal) {
        adoptedAnimals.add(animal);
        allAnimals.remove(animal);
        shelter.saveAnimals();
    }

    @Override
    public void showAdoptedAnimals() {
        System.out.println("Выбранные животные:");
        if (adoptedAnimals.isEmpty()) {
            System.out.println("Нет выбранных животных.");
        } else {
            for (Animal animal : adoptedAnimals) {
                animal.displayInfo();
            }
        }
    }

    @Override
    public void addAnimal(Animal animal) {
        allAnimals.add(animal);
        shelter.saveAnimals();
    }

    @Override
    public double getTotalCareCost() {
        return adoptedAnimals.stream().mapToDouble(Animal::getCareCost).sum();
    }

    @Override
    public String generateReceipt() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("----- Чек содержания животных -----\n");
        receipt.append("Количество выбранных животных: ").append(adoptedAnimals.size()).append("\n");
        receipt.append("Общая стоимость содержания: ").append(getTotalCareCost()).append(" руб.\n");
        receipt.append("-----------------------------------\n");
        return receipt.toString();
    }

    @Override
    public List<Animal> getAllAnimals() {
        return new ArrayList<>(allAnimals); // Возвращаем копию списка
    }

    @Override
    public List<Animal> getAdoptedAnimals() {
        return new ArrayList<>(adoptedAnimals); // Возвращаем копию списка
    }
}
