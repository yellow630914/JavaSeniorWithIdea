package MultiThreading;

/*
    線程安全問題:
        多個線程執行的不確定性引起執行結果的不穩定
        多個線程對賬本的共享，會造成操作的不完整性，會破壞數據。

    例子:三窗口賣票,有可能出現超賣 --> 出現現成安全問題。
    問題出現原因:當一個線程在操作車票的過程中,尚未完成操作,其他線程也參與近來,造成超賣。
    問題解決:當一個線程在操作共享數據時,其他線程不能參與近來,直到一個線程操作完,其他線程才能繼續操作,即使這個線程出現阻塞。
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

    @Override
    public void run() {
        while(true){
            if(ticket > 0){
                try{
                    //增加超賣概率
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                if(ticket <= 0){
                    System.out.println(Thread.currentThread().getName() + "超賣,票號為" + ticket--);
                }else {
                    System.out.println(Thread.currentThread().getName() + "賣票,票號為" + ticket--);
                }
            }else {
                break;
            }
        }
    }
}
