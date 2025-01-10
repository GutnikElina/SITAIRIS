import Models.Animal;

import java.util.Scanner;

public class Menu {
    private final AdoptionService adoptionService;

    public Menu(AdoptionService adoptionService) {
        this.adoptionService = adoptionService;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Добавить животное.");
            System.out.println("2. Показать всех животных.");
            System.out.println("3. Показать животные которых забрали.");
            System.out.println("4. Забрать животное.");
            System.out.println("5. Вывести чек содержания.");
            System.out.println("6. Выход.");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addAnimal(scanner);
                    break;
                case 2:
                    showAllAnimals();
                    break;
                case 3:
                    adoptionService.showAdoptedAnimals();
                    break;
                case 4:
                    adoptAnimal(scanner);
                    break;
                case 5:
                    System.out.println(adoptionService.generateReceipt());
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private void addAnimal(Scanner scanner) {
        System.out.println("Введите имя животного: ");
        String name = scanner.nextLine();

        System.out.println("Введите стоимость содержания: ");
        double careCost = scanner.nextDouble();

        AnimalFactory animalFactory = new AnimalFactoryImpl();
        Animal animal = animalFactory.createAnimal(name, careCost);

        adoptionService.addAnimal(animal);
        System.out.println("Животное добавлено!");
    }

    private void showAllAnimals() {
        System.out.println("Все животные:");
        for (Animal animal : adoptionService.getAllAnimals()) {
            animal.displayInfo();
        }
    }

    private void adoptAnimal(Scanner scanner) {
        System.out.println("Введите имя животного, которое хотите забрать: ");
        String name = scanner.nextLine();
        Animal animalToAdopt = null;
        for (Animal animal : adoptionService.getAllAnimals()) {
            if (animal.getName().equalsIgnoreCase(name)) {
                animalToAdopt = animal;
                break;
            }
        }
        if (animalToAdopt != null) {
            adoptionService.adoptAnimal(animalToAdopt);
            System.out.println("Животное выбрано!");
        } else {
            System.out.println("Животное с таким именем не найдено.");
        }
    }
}
