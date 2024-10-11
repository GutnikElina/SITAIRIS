// Класс 14: Постоянный зритель
public class RegularViewer extends Viewer {
    @Override
    public String watchMovie(String movieName) {
        return "Watching " + movieName + " in regular mode.";
    }
}