// Интерфейс 2: Операции кассира
public interface CashierOperations extends CinemaOperations {
    int returnTicket(int seatNumber, int price);
}