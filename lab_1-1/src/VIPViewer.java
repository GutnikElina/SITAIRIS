// Класс 8: VIP зритель
public class VIPViewer implements ViewerOperations, CashierOperations {
    @Override
    public int sellTicket(int seatNumber, int price) {
        int newPrice = price + 100;
        System.out.println("Ticket sold for seat " + seatNumber + " at price $" + newPrice);
        return newPrice;
    }

    @Override
    public String watchMovie(String movieName) {
        return "Watching " + movieName + " in VIP lounge.";
    }

    @Override
    public int returnTicket(int seatNumber, int price) {
        return price  + 100;
    }
}