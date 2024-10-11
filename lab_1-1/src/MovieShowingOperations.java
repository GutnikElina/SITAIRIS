// Интерфейс 5: Управление показом фильмов
public interface MovieShowingOperations extends CinemaOperations {
    int scheduleMovie(int movieId, int showtime);
}
