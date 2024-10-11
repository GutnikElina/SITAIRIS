// Класс 10: Управляющий кинотеатром
public class CinemaManager implements ViewerOperations, ManagementOperations, MovieShowingOperations {
    @Override
    public String watchMovie(String movieName) {
        return movieName + " is under supervision.";
    }

    @Override
    public void manageCinema(String cinemaName) {
        System.out.println("Managing cinema: " + cinemaName);
    }

    @Override
    public void scheduleMovie(int movieId, int showtime) {
    }
}
