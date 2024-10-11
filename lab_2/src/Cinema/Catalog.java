package Cinema;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private static List<String> catalog;

    static {
        catalog = new ArrayList<>();
        catalog.add("- Команда монстров");
        catalog.add("- Формула воды");
        catalog.add("- Трансформеры: Начало");
        catalog.add("- Ленивая семейка");
        catalog.add("- 9 секунд");
        catalog.add("- Граф Монте-Кристо");
        catalog.add("- Агент на уикенд");
        catalog.add("- Беляковы в отпуске");
        catalog.add("- Субстанция");
        catalog.add("- Другой человек");
    }

    public static void provideMovieCatalog() {
        System.out.println("\n+----------КАТАЛОГ ФИЛЬМОВ----------+");
        catalog.forEach(System.out::println);
        System.out.println("+-------------------------------------+");
    }
}