public class MainCinema {
    public static void main(String[] args) {
        Cashier cashier = new Cashier();
        JuniorEmployee juniorEmployee = new JuniorEmployee();
        VIPViewer vipViewer = new VIPViewer();
        CinemaManager manager = new CinemaManager();
        MovieScheduler scheduler = new MovieScheduler();
        SeniorEmployee seniorEmployee = new SeniorEmployee();
        RegularViewer regularViewer = new RegularViewer();
        SeniorScheduler seniorScheduler = new SeniorScheduler();

        cashier.sellTicket(1, 15);
        juniorEmployee.sellTicket(2, 20);
        vipViewer.sellTicket(3, 50);
        seniorEmployee.sellTicket(4, 100);

        System.out.println();

        System.out.println(vipViewer.watchMovie("Interstellar"));
        System.out.println(manager.watchMovie("Duna"));
        System.out.println(regularViewer.watchMovie("Titanik"));

        System.out.println();

        seniorEmployee.returnTicket(4, 100);

        seniorEmployee.calculateWorkHours(19, 8);

        manager.manageCinema("CinemaX");
        seniorScheduler.manageCinema("ProjectCinema");

        System.out.println();

        scheduler.scheduleMovie(101, 19);
        seniorScheduler.scheduleMovie(34, 21);


    }
}
