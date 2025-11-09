public class BookingThread extends Thread {
    private String customerName;
    private int ticketId;
    private SpaceTicket spaceTicket;

    public BookingThread(String customerName, int ticketId, SpaceTicket spaceTicket) {
        this.customerName = customerName;
        this.ticketId = ticketId;
        this.spaceTicket = spaceTicket;
    }

    @Override
    public void run() {
        Ticket ticket = spaceTicket.getTicketById(ticketId);
        if (ticket == null) {
            System.out.println(customerName + " Tiket tidak ditemukan.");
            return;
        }

        boolean success = spaceTicket.bookTicket(ticketId);
        if (success) {
            System.out.println(customerName + " berhasil memesan tiket ke " + ticket.getDestination() + " seharga " + ticket.getPrice());
        } else {
            System.out.println( customerName + " gagal, tiket ke " + ticket.getDestination() + " sudah habis!");
        }
    }
}
