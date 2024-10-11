import Cinema.Film;
import Visitor.Visitor;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Visitor visitor1 = new Visitor("Элина", 160);
        System.out.println(visitor1.toString());
        Scanner scanner = new Scanner(System.in);
        boolean flag2 = true;

        while (flag2) {
            visitor1.requestMovieCatalog();
            System.out.println("! Чтобы выйти введите 0 !");
            System.out.println("+-------------------------------------+");

            boolean flag;
            String filmName;
            do {
                System.out.println("Выберите фильм из представленного каталога: ");
                filmName = scanner.nextLine();

                flag = visitor1.findFilmInformation(filmName);
            } while (!flag);

            if (!filmName.equals("0")) {
                String tick = visitor1.buyTicket(filmName);
                if (!Objects.equals(tick, "!!! Cinema: К сожалению, в наличии нет билетов на выбранный фильм...")) {
                    visitor1.setTickets(tick);
                } else {
                    System.out.println(tick);
                    System.out.println("+-------------------------------------+");
                }
                System.out.println(visitor1.toString());
            } else {
                flag2 = false;
            }
        }
        scanner.close();
    }
}