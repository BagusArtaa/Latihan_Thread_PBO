public class Main{
    public static void main(String[] args) {
        SpaceTicket spaceTicket = new SpaceTicket();

        spaceTicket.showAllTickets();

        Thread t1 = new BookingThread("Laika", 1, spaceTicket);
        Thread t2 = new BookingThread("Belka", 1, spaceTicket);
        Thread t3 = new BookingThread("Strelka", 2, spaceTicket);
        Thread t4 = new BookingThread("Enos", 2, spaceTicket);
        Thread t5 = new BookingThread("Félicette", 3, spaceTicket);
        Thread t6 = new BookingThread("Arabella", 3, spaceTicket);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
