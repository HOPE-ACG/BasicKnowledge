import MutiThread.EntryLevel;

public class TestEntryLevel {

    public static void main(String[] args) throws InterruptedException {

        final EntryLevel thread1 = new EntryLevel();
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                try {
                    thread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0) {
                        System.out.println("Current Thread :" + Thread.currentThread().getName() + " num:" + i);
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
