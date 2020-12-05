package threading;

import java.util.Scanner;

/**
 * Created by sabrouch.
 * Date: 12/5/2020
 */

class Processor extends Thread{
    private boolean running=true;
    @Override
    public void interrupt() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(running){
            System.out.println("hello");
try {
    Thread.sleep(100);
} catch (InterruptedException e) {
    e.printStackTrace();
}
        }
    }
    public void shutdown(){
        running = false;
    }


}

public class AppThread {
    public static void main(String[] args) {
        Processor  proc = new Processor();
        proc.start();
        System.out.println("press return to stop it");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        proc.shutdown();
    }


}
