package MultiThreading;

/*
    方式一：繼承Thread類
        1.  定義子類繼承Thread類。
        2.  子類中重寫Thread類中的run方法。
        3.  創建Thread子類物件，即創建了線程物件。
        4.  調用線程物件start方法：啟動線程，調用run方法。

    注意點：
        1. 如果自己手動調用run()方法，那麼就只是普通方法，沒有啟動多線程模式。
        2. run()方法由JVM調用，什麼時候調用，執行的過程控制都有操作系統的CPU調度決定。
        3. 想要啟動多線程，必須調用start方法。
        4. 一個線程對像只能調用一次start()方法啟動，如果重複調用了，則將拋出以上的異常“IllegalThreadStateException”。


 */

public class ThreadIntro {
    public static void main(String[] args) {
        //3.  創建Thread子類物件，即創建了線程物件。
        MyThread t1 = new MyThread();

        //4.  調用線程物件start方法：(1)啟動線程(2)調用run方法。
        t1.start();

        for (int i = 0; i < 20; i++) {
            System.out.println('a' + i + "withMain");
        }

        //一個線程對像只能調用一次start()方法啟動，如果重複調用了，則將拋出以上的異常“IllegalThreadStateException”。
        //t1.start();
        //重新創建一個線程物件,即可再次使用。
        MyThread t2 = new MyThread();
        t2.start();
    }
}
//1.  定義子類繼承Thread類。
class MyThread extends Thread{


    //2.  子類中重寫Thread類中的run方法。
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}
