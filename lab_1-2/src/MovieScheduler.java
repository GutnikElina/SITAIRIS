// Класс 11: Операции по показу фильмов
public class MovieScheduler implements MovieShowingOperations, ManagementOperations {
    @Override
    public void scheduleMovie(int movieId, int showtime) {
        System.out.println("Movie " + movieId + " scheduled at " + showtime);
    }

    @Override
    public void manageCinema(String cinemaName) {
        System.out.println("Schedule to the cinema " + cinemaName + " is done.");
    }
}