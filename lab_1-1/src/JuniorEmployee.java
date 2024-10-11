// Конкретные классы 12 и 13: Сотрудники разного уровня
public class JuniorEmployee extends CinemaEmployee {
    @Override
    public int calculateWorkHours(int daysWorked, int hoursPerDay) {
        return daysWorked * hoursPerDay;
    }
}
()->{tyu}