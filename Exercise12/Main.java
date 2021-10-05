package ru.Makval;

class MyThread extends Thread{
    @Override
    public void run() {
        for(int j = 0; j < 100; j++)
        {
            System.out.print(j + ", ");
        }
        System.out.println();
    }
}

class MyNewThread extends Thread{
    @Override
    public void run() {
        Main.Counter counter = new Main.Counter();
        for(int i = 0; i < 1000; i++){
            counter.increment();
        }
        System.out.println(counter.count);
    }
}

class StepThread extends Thread {

    private Object lock;

    public StepThread(Object object) {
        this.lock = object;
    }
    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                try {
                    System.out.println(getName());
                    lock.notify();
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here


//        for(int i = 0; i < 10; i++) {
//            new MyThread().start();
//            MyThread.currentThread().setName("My thread " + (i+1));
//            System.out.println("Thread name: " + MyThread.currentThread().getName());
//        }


        //__________2_______________________________
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println(getState());
            }
        };

        System.out.println(thread.getState());

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getState());
        //_________________________________________________


        //_______3____________________________________________
        for(int i = 0; i < 100; i++) {
            //System.out.println(i+1 + " ");
            new MyNewThread().start();
        }
        //_____________________________________________________


        //______________________4_______________________________
        Object lock = new Object();
        new StepThread(lock).start();
        new StepThread(lock).start();
        //__________________________________________________________

    }

    public static class Counter {
        int count = 0;
        public void increment() {
            count += 1;
        }
        public int getCount() {
            return count;
        }
    }
}
