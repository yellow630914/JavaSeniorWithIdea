package MultiThreading;

/*
    Thread類的常用方法:

    void start():  啟動線程，並執行物件的run()方法
    run():  線程在被調度時執行的操作
    String getName():  返迴線程的名稱
    void setName(String name):   設置該線程名稱
    static Thread currentThread():  返回當前線程。在Thread子類中就是this，通常用於主線程和Runnable實現類
    static  void  yield()：線程讓步
        暫停當前正在執行的線程，把執行機會讓給優先級相同或更高的線程
        若隊列中沒有同優先級的線程，忽略此方法
    join() ：當某個程序執行流中調用其他線程的 join() 方法時，調用線程將被阻塞，直到 join() 方法加入的 join 線程執行完為止
        低優先級的線程也可以獲得執行
    static  void  sleep(long millis)：(指定時間:毫秒)
        令當前活動線程在指定時間段內放棄對CPU控制,使其他線程有機會被執行,時間到後重排隊。
        拋出InterruptedException異常
    stop(): 強制線程生命期結束，不推薦使用
    boolean isAlive()：返回boolean，判斷線程是否還活著

    線程的優先級:
     線程的優先級等級
        MAX_PRIORITY：10
        MIN _PRIORITY：1
        NORM_PRIORITY：5
     涉及的方法
        getPriority() ：返迴線程優先值
        setPriority(int newPriority) ：改變線程的優先級
     說明
        線程創建時繼承父線程的優先級
        低優先級只是獲得調度的概率低，並非一定是在高優先級線程之後才被調用

 */

public class ThreadMethodIntro {
    public static void main(String[] args) {
        HelloThread h1 = new HelloThread("線程一");

        //設定優先級
        h1.setPriority(Thread.MAX_PRIORITY);

        h1.start();

        Thread.currentThread().setName("主線程");

        for (int i = 0; i < 100; i++) {
            if(i % 2 == 1){
                System.out.println(Thread.currentThread().getName() + ":線程優先級." + Thread.currentThread().getPriority() + "::" + i);
            }

            if(i == 20){
                try {
                    //join() ：當某個程序執行流中調用其他線程的 join() 方法時，調用線程將被阻塞，直到 join() 方法加入的 join 線程執行完為止
                    h1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(h1.isAlive());
    }
}

class HelloThread extends Thread{
    private final String threadName;//線程名

    public HelloThread(String threadName) {
        this.threadName = threadName;
    }
    //為線程取名
    private void setThreadName(String threadName){
        Thread.currentThread().setName(threadName);
    }

    @Override
    public void run() {
        setThreadName(this.threadName);
        for (int i = 0; i < 100; i++) {

            if(i % 2 == 0){
                try {
//                  void  sleep(long millis)：(指定時間:毫秒)
//                  令當前活動線程在指定時間段內放棄對CPU控制,使其他線程有機會被執行,時間到後重排隊。
//                  拋出InterruptedException異常
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + ":線程優先級." + getPriority() +"::"+ i);
            }
            if(i % 5 == 0){
//              yield()：線程讓步
//              暫停當前正在執行的線程，把執行機會讓給優先級相同或更高的線程
//              若隊列中沒有同優先級的線程，忽略此方法
                Thread.yield();
            }
        }
    }


}
