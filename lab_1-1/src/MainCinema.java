public class MainCinema {
    public static void main(String[] args) {
        Cashier cashier = new Cashier();
        JuniorEmployee juniorEmployee = new JuniorEmployee();
        VIPViewer vipViewer = new VIPViewer();
        CinemaManager manager = new CinemaManager();
        MovieScheduler scheduler = new MovieScheduler();

        cashier.sellTicket(1, 15);
        juniorEmployee.sellTicket(2, 20);
        vipViewer.sellTicket(3, 50);

        System.out.println();

        System.out.println(vipViewer.watchMovie("Inception"));
        System.out.println(manager.watchMovie("Matrix"));

        System.out.println();

        manager.manageCinema("CinemaX");

        System.out.println();

        scheduler.scheduleMovie(101, 19);
    }
}
