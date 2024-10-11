package Cinema;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Film {
    private static Map<String, String> infFilm;

    static {
        infFilm = new HashMap<>();
        infFilm.put("Команда монстров", "Детский/Фэнтези");
        infFilm.put("Формула воды", "Мультфильм/Фэнтези");
        infFilm.put("Трансформеры: Начало", "Боевик/Научная фантастика");
        infFilm.put("Ленивая семейка", "Приключения/Детский");
        infFilm.put("9 секунд", "Драма");
        infFilm.put("Граф Монте-Кристо", "Приключения/Триллер");
        infFilm.put("Агент на уикенд", "Боевик/Триллер");
        infFilm.put("Беляковы в отпуске", "Комедия/Приключения");
        infFilm.put("Субстанция", "Ужасы/Научная фантастика");
        infFilm.put("Другой человек", "Триллер/Драма");
    }

    public static boolean sendFilmInformation(String filmName) {
        if (infFilm.containsKey(filmName)) {
            System.out.println("+-------------------------------------+");
            System.out.println("-> Film: Информация о выбранном фильме " + "'" + filmName + "':\n" + infFilm.get(filmName));
            return true;
        } else if(Objects.equals(filmName, "0")){
            System.out.println("+------------GOODBYE-----------------+");
            return true;
        } else {
            System.out.println("+-------------------------------------+");
            System.out.println("-!!!- В каталоге нашего кинотеатра нет такого фильма. Попробуйте снова -!!!-");
            System.out.println("+-------------------------------------+");
            return false;
        }
    }
}
