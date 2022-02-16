package MultiThreading;

/*
    線程安全問題:
        多個線程執行的不確定性引起執行結果的不穩定
        多個線程對賬本的共享，會造成操作的不完整性，會破壞數據。

    例子:三窗口賣票,有可能出現超賣 --> 出現現成安全問題。
    問題出現原因:當一個線程在操作車票的過程中,尚未完成操作,其他線程也參與近來,造成超賣。
    問題解決:當一個線程在操作共享數據時,其他線程不能參與近來,直到一個線程操作完,其他線程才能繼續操作,即使這個線程出現阻塞。

    在Java中,我們透過我們透過同步機制,線程安全問題。

        方式一: 同步代碼塊
            synchronized(同步監視器){
                //需要被同步的代碼
            }
            說明:1.操作共享數據的代碼,即為需要被同步的代碼。
                2.共享數據:多個線程都會操作到的數據。例如:ticket
                3.同步監視器,俗稱"鎖":任何一個類的物件都能充當鎖。
                    !!!要求:多個線程必須要共用同一把鎖。

        方式二: 同步方法
            如果操作共享數據的代碼完整生明在一個方法中,我們不妨將此方法聲明為同步的。
            在繼承Thread類的線程中,同步方法要是靜態的,否則會使用不同的鎖。

    同步的方式:解決了線程安全問題。--優點
             操作同步代碼時,只能有一個現成參與,相當於是一個單線程,效率低。--缺點

 */

public class SynchronizedIntro {
    public static void main(String[] args) {
        Window w1 = new Window();
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.start();
        t2.start();
        t3.start();

    }
}

class Window implements Runnable{

    private int ticket = 100;
    //多個線程必須共用同一把鎖
    final Object watcher = new Object();

    @Override
    public void run() {
        while(true) {
            //同步代碼塊
            synchronized (watcher) { //當使用Runnable實現多線程時,也可使用this
                if (ticket > 0) {
                    try {
                        //增加超賣機率
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (ticket <= 0) {
                        System.out.println(Thread.currentThread().getName() + "超賣,票號為" + ticket--);
                    } else {
                        System.out.println(Thread.currentThread().getName() + "賣票,票號為" + ticket--);
                    }
                } else {
                    break;
                }
            }
        }
    }
}
