package Cinema;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    private static Map<String, Integer> amountOfTickets;

    static {
        amountOfTickets = new HashMap<>();
        amountOfTickets.put("Команда монстров", 2);
        amountOfTickets.put("Формула воды", 5);
        amountOfTickets.put("Трансформеры: Начало", 0);
        amountOfTickets.put("Ленивая семейка", 1);
        amountOfTickets.put("9 секунд", 2);
        amountOfTickets.put("Граф Монте-Кристо", 3);
        amountOfTickets.put("Агент на уикенд", 4);
        amountOfTickets.put("Беляковы в отпуске", 5);
        amountOfTickets.put("Субстанция", 2);
        amountOfTickets.put("Другой человек", 0);
    }

    public static boolean checkAvailability(String filmName) {
        System.out.println("+-------------------------------------+");
        System.out.println("-> Manager: Проверка наличия билета на фильм " + filmName);
        if (amountOfTickets.get(filmName)>0) {
            System.out.println("Количество билетов до покупки: " + amountOfTickets.get(filmName));
            int am = amountOfTickets.get(filmName) - 1;
            amountOfTickets.replace(filmName, am);
            System.out.println("Количество билетов после покупки: " + amountOfTickets.get(filmName));
            return true;
        } else {
            return false;
        }
    }
}
