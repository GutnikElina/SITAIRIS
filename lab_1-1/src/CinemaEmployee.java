// Абстрактный класс 7: Сотрудник кинотеатра
public abstract class CinemaEmployee implements CashierOperations {
    @Override
    public int sellTicket(int seatNumber, int price) {
        System.out.println("Ticket sold for seat " + seatNumber + " at price $" + price);
        return price;
    }

    @Override
    public int returnTicket(int seatNumber, int price) {
        return price / 2;
    }

    public abstract int calculateWorkHours(int daysWorked, int hoursPerDay);
}