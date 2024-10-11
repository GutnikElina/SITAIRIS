// Класс 10: Управляющий кинотеатром
public class CinemaManager implements ViewerOperations, ManagementOperations, MovieShowingOperations {
    @Override
    public int sellTicket(int seatNumber, int price) {
        System.out.println("Ticket sold for seat " + seatNumber + " at price $" + price);
        return price;
    }

    @Override
    public String watchMovie(String movieName) {
        return movieName + " is under supervision.";
    }

    @Override
    public void manageCinema(String cinemaName) {
        System.out.println("Managing cinema: " + cinemaName);
    }

    @Override
    public int scheduleMovie(int movieId, int showtime) {
        return showtime;
    }
}
