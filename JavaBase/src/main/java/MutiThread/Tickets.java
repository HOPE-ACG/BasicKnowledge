package MutiThread;

/**
 * Train tickets sale
 */
public class Tickets implements Runnable {

    /**
     * Total tickets
     */
    private int tickets = 1000;

    public void run() {
        while (true) {
            synchronized (this) {
                if (tickets > 0) {
                    System.out.println("窗口" + Thread.currentThread().getName() + "\t您的票号:" + (1001 - tickets) + "\t当前剩余票数:" + --tickets);
                }else {
                    System.out.println("票已售空");
                    break;
                }
            }
        }
    }
}
