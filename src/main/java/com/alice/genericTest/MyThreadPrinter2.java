package com.alice.genericTest;

public class MyThreadPrinter2 implements Runnable {
    private static boolean ready;
    private static int number;
    private String name;
    private Object prev;
    private Object self;

    private MyThreadPrinter2(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (prev) {
                /*self锁*/
                synchronized (self) {
                    System.out.print(name);
                    count--;

                    self.notify();//唤醒其他线程，但是线程依旧保持有self对象锁，
                    // 所以其他线程虽然被唤醒，但仍无法获得self锁，直到调用线程退出synchronized块，
                    //释放self锁，其他线程中的某个线程才有机会获得锁继续执行
                }
                /*prev锁*/
                try {
                    //在此synchronized代码块中，prev是锁对象，该进程进入等待
                    prev.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready){
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
//    public static void main(String[] args) throws Exception {
//        Object a = new Object();
//        Object b = new Object();
//        Object c = new Object();
//        MyThreadPrinter2 pa = new MyThreadPrinter2("A", c, a);
//        MyThreadPrinter2 pb = new MyThreadPrinter2("B", a, b);
//        MyThreadPrinter2 pc = new MyThreadPrinter2("C", b, c);
//
//
//        new Thread(pa).start();
//        Thread.sleep(100);  //确保按顺序A、B、C执行
//        new Thread(pb).start();
//        Thread.sleep(100);
//        new Thread(pc).start();
//        Thread.sleep(100);
//    }
}