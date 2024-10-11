// Класс 15: Специалист по показу фильмов
public class SeniorScheduler extends MovieScheduler {
    @Override
    public void scheduleMovie(int movieId, int showtime) {
        System.out.println("Senior Scheduler scheduled movie " + movieId + " at " + (showtime + 1));
    }
}