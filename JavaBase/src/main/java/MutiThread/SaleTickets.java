package MutiThread;

public class SaleTickets {

    /**
     * Tickets sale window
     */
    public static void main(String[] args) {
        Tickets tickets = new Tickets();
        Thread window1 = new Thread(tickets);
        Thread window2 = new Thread(tickets);
        Thread window3 = new Thread(tickets);

        window2.setPriority(10);

        window1.start();
        window2.start();
        window3.start();
    }
}
