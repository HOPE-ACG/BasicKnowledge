package MutiThread;

public class EntryLevel extends Thread{

    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            if(i % 2 == 0) {
                System.out.println("Current Thread" + Thread.currentThread().getName() + " num:" + i);
            }
        }
    }
}
