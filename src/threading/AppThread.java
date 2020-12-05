package threading;

/**
 * Created by sabrouch.
 * Date: 12/5/2020
 */

class Processor extends Thread{
    @Override
    public void run() {
        while(true){
            System.out.println("hello");
try {
    Thread.sleep(100);
} catch (InterruptedException e) {
    e.printStackTrace();
}
        }
    }
}

public class AppThread {
    public static void main(String[] args) {
        Processor  proc = new Processor();
        proc.start();
    }

}
