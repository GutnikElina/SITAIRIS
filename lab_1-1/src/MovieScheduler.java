// Класс 11: Операции по показу фильмов
public class MovieScheduler implements MovieShowingOperations, ManagementOperations {
    @Override
    public int sellTicket(int seatNumber, int price) {
        System.out.println("Ticket sold for seat " + seatNumber + " at price $" + price);
        return price;
    }

    @Override
    public int scheduleMovie(int movieId, int showtime) {
        System.out.println("Movie " + movieId + " scheduled at " + showtime);
        return showtime;
    }

    @Override
    public void manageCinema(String cinemaName) {
        System.out.println("Schedule to the cinema " + cinemaName + " is done.");
    }
}