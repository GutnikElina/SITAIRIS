// Интерфейс 2: Операции кассира
public interface CashierOperations {
    int returnTicket(int seatNumber, int price);
    void sellTicket(int seatNumber, int price);
}