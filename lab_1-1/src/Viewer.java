// Абстрактный класс 9: Зритель
public abstract class Viewer implements ViewerOperations {
    @Override
    public int sellTicket(int seatNumber, int price) {
        System.out.println("Ticket sold for seat " + seatNumber + " at price $" + price);
        return price;
    }

    @Override
    public abstract String watchMovie(String movieName);
}
