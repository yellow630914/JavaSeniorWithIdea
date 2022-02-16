package MultiThreading;

/*
    JDK5.0後新增的線程安全解決方案: Lock

    1.先聲明一個ReentrantLock的物件(fair:讓Lock遵循先進先出)
    2.調用lock方法
    3.調用unlock方法

    -面試題synchronized與lock的異同?
    1.都是用於解決線程安全問題
    2.synchronized會自動釋放同步監視器
      lock需要手動上鎖與手動解鎖


 */

import java.util.concurrent.locks.ReentrantLock;

public class LockIntro {
    public static void main(String[] args) {
        Kitchen k = new Kitchen();

        Thread t1 = new Thread(k);
        Thread t2 = new Thread(k);
        Thread t3 = new Thread(k);

        t1.start();
        t2.start();
        t3.start();
    }
}

class Kitchen implements Runnable{
    private int food = 100;
    //1.先聲明一個ReentrantLock的物件(fair:讓Lock遵循先進先出)
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true) {
            try {
                //2.調用lock方法
                lock.lock();

                if (food > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "出單,食物剩下:" + food--);
                } else {
                    break;
                }
            }finally {
                //3.調用unlock方法
                lock.unlock();
            }
        }
    }
}
