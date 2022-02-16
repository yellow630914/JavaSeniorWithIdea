package MultiThreading;

/*
    使用同步方法解決Runnable線程安全問題

    關於同步方法的總結:
    1.同步方法仍有同步監視器,但不需我們顯式聲明。
    2.非靜態的同步方法監視器是this
      靜態同步方法監視器是類本身。
 */

public class SynchronizedMethod {
    public static void main(String[] args) {
        Windows w1 = new Windows();
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.start();
        t2.start();
        t3.start();

    }
}


class Windows implements Runnable{

    private int ticket = 100;

    @Override
    public void run() {
        while(ticket >= 0) {
            sellTickets();
        }
    }

    private synchronized void sellTickets(){
        if (ticket > 0) {
            try {
                //增加超賣機率
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "賣票,票號為" + ticket--);

        }
    }
}