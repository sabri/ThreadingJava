package threading;

/**
 * Created by sabrouch.
 * Date: 12/5/2020
 */

public class SyncThread {
   private int count = 0;

    public static void main(String[] args) {
SyncThread s = new SyncThread();
s.dowork();
    }
    public void dowork(){
        Runnable target;
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100;i++){
                    count++;
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100;i++){
                    count++;
                }
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);
    }
}
