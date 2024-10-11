// Реальный класс 6: Кассир
public class Cashier implements CashierOperations {
    @Override
    public void sellTicket(int seatNumber, int price) {
        System.out.println("Ticket sold for seat " + seatNumber + " at price $" + price);
    }

    @Override
    public int returnTicket(int seatNumber, int price) {
        System.out.println("Ticket returned for seat " + seatNumber);
        return price / 2; // возврат половины стоимости
    }

    public int checkBalance(int ticketsSold, int ticketPrice) {
        return ticketsSold * ticketPrice;
    }
}
