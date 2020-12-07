package threading;

/**
 * Created by sabrouch.
 * Date: 12/5/2020
 */

public class JavaThreadPrioirty extends Thread{
    @Override
    public void run() {
        System.out.println("inside run method");
    }

    public static void main(String[] args) {
        JavaThreadPrioirty t1 = new JavaThreadPrioirty();
        JavaThreadPrioirty t2 = new JavaThreadPrioirty();
        JavaThreadPrioirty t3 = new JavaThreadPrioirty();

        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        System.out.println(t3.getPriority());
        t1.setPriority(2);
        t2.setPriority(5);
        t3.setPriority(8);
        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        System.out.println(t3.getPriority());
        System.out.println(t1.getName());
        System.out.println(t2.getName());
        System.out.println(t3.getName());
        System.out.println(Thread.currentThread().getPriority());

    }
}
