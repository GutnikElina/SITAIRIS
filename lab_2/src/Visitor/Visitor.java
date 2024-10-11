package Visitor;

import Cinema.Catalog;
import Cinema.Film;
import Cinema.Cinema;
import java.util.ArrayList;
import java.util.List;
import static java.lang.Double.parseDouble;

public class Visitor {
    private String name;
    private double money;
    private List<String> tickets;

    public Visitor(String name, double money) {
        this.name = name;
        this.money = money;
        this.tickets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public List<String> getTickets() {
        return tickets;
    }

    public void setTickets(String tickets) {
        this.tickets.add(tickets);
    }

    public void requestMovieCatalog() {
        Catalog.provideMovieCatalog();
    }

    public boolean findFilmInformation(String filmName) {
        return Film.sendFilmInformation(filmName);
    }

    public String buyTicket(String filmName) {
        if (Cinema.checkAvailability(filmName)) {
            String ticket = Cinema.sendTicket(filmName);
            double price = Math.random()*10;
            String formattedDouble = String.format("%.1f", price);
            ticket += ", Цена: " + formattedDouble;
            this.setMoney(getMoney()-price);
            System.out.println("Со счета посетителя снялось " + formattedDouble + " рублей.");
            System.out.println("+----------------------------+");
            return ticket;
        } else {
            System.out.println("+-------------------------------------+");
            return Cinema.messageNoTicket();
        }
    }


    @Override
    public String toString() {
        String formattedDouble = String.format("%.2f", money);
        return "Visitor{" +
                "name='" + name + '\'' +
                ", money=" + formattedDouble +
                ", tickets=" + tickets +
                '}';
    }
}
