package Cinema;

public class Cinema {
    private static final String nameOfCinema = "'CineRate'";

    public static boolean checkAvailability(String filmName) {
        return Manager.checkAvailability(filmName);
    }

    public static String sendTicket(String filmName) {
        System.out.println("+-------------------------------------+");
        System.out.println("-> Cinema: Вы приобрели билет на фильм '" + filmName + "' в кинотеатре " + nameOfCinema);
        return "Кинотеатр: " + nameOfCinema + ", Фильм: " + filmName;
    }

    public static String messageNoTicket() {
        return "!!! Cinema: К сожалению, в наличии нет билетов на выбранный фильм...";
    }
}
