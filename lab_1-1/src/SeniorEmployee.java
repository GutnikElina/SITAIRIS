//Класс 13
public class SeniorEmployee extends CinemaEmployee {
    @Override
    public int calculateWorkHours(int daysWorked, int hoursPerDay) {
        return (daysWorked * hoursPerDay) + 10; // дополнительное время
    }
}
