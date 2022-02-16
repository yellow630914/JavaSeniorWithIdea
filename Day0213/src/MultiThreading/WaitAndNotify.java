package MultiThreading;

/*
    線程的通信例子:使用2個線程打印1-100,交替打印。

     wait() 與 notify() 和 notifyAll()
        wait()：令當前線程掛起並放棄CPU、同步資源並等待，使別的線程可訪問並修改共享資源，而當前線程排隊等候其他線程調用notify()或notifyAll
            ()方法喚醒，喚醒後等待重新獲得對監視器的所有權後才能繼續執行。
        notify()：喚醒正在排隊等待同步資源的線程中優先級最高者結束等待
        notifyAll ()：喚醒正在排隊等待資源的所有線程結束等待.
     這三個方法只有在synchronized方法或synchronized代碼塊中才能使用，否則會報java.lang.IllegalMonitorStateException異常。
     因為這三個方法必須有鎖對象調用，而任意對像都可以作為synchronized的同步鎖，因此這三個方法只能在Object類中聲明。

    面試題: sleep()和wait()的異同點?
    1.相同: 一旦執行,都可以造成現成堵塞。
    2.不同:(1)兩個方法聲明位置不同:Thread類中聲明sleep,Object類聲明wait();
          (2)sleep可以在線程任何位置調用,wait只能在synchronized中。
          (3)sleep不會釋放鎖,wait會。


 */

public class WaitAndNotify {
    public static void main(String[] args) {
        Number n = new Number();

        Thread t1 = new Thread(n);
        Thread t2 = new Thread(n);

        t1.start();
        t2.start();
    }
}

class Number implements Runnable{
    private int number = 1;

    @Override
    public void run() {

        while (true){
            synchronized (this) {
                //喚醒正在阻塞的線程
                notify();

                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName() + " : " + number++);

                    try {
                        //使得調用如下方法的線程進入阻塞狀態
                        //wait是會釋放鎖的
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}
