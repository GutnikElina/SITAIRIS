// Абстрактный класс 9: Зритель
public abstract class Viewer implements ViewerOperations {
    @Override
    public abstract String watchMovie(String movieName);
}
