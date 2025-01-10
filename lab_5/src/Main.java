public class Main {
    public static void main(String[] args) {
        String filePathAll = "animals.xml";
        String filePathAdopted = "adopted_animals.xml";
        AnimalShelter shelter = AnimalShelter.getInstance(filePathAll, filePathAdopted);
        Menu menu = new Menu(shelter.getAdoptionService());
        menu.showMenu();
        shelter.saveAnimals();
    }
}
