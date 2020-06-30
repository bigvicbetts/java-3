package concurrency;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

class Sync extends Thread {
    static List nums = new ArrayList<>();

    Sync(String name) {
        super(name);
    }

    @Override 
    public void run() {
        Random rand = new Random();

        synchronized (this) {
        for(int i=0; i<100; i++) {
            int randInt = rand.nextInt(100);
            this.nums.add(randInt);
            System.out.println(this.getName() + " - " + randInt);
        }
        }
    }

    public static void main(String[] args)  {
        Sync syncThread = new Sync("sync thread");
        Sync syncThread2 = new Sync("sync thread 2");
        Sync syncThread3 = new Sync("sync thread 3");
        Sync syncThread4 = new Sync("sync thread 4");
        Sync syncThread5 = new Sync("sync thread 5");

        synchronized (nums) {
            syncThread.start();
            syncThread2.start();
            syncThread3.start();
            syncThread4.start();
            syncThread5.start();
        }

        try {
            syncThread.join();
            syncThread2.join();
            syncThread3.join();
            syncThread4.join();
            syncThread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(syncThread.nums);
        //this prints out an empty list. write some code that will allow the data generated in the syncThread
        // to show up  here.  There is a brute force way and a more sophisticated way.  Either or will work,
        // but strive for sophistication :)

    }
    
}