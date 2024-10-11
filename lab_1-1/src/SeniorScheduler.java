// Класс 15: Специалист по показу фильмов
public class SeniorScheduler extends MovieScheduler {
    @Override
    public int scheduleMovie(int movieId, int showtime) {
        System.out.println("Senior Scheduler scheduled movie " + movieId + " at " + (showtime + 1));
        return showtime + 1; // добавлено время на подготовку
    }
}