package MultiThreading;
/*
     方式二：實現Runnable接口
    1. 定義子類，實現Runnable接口。
    2. 子類中重寫Runnable接口中的run方法。
    3. 通過Thread類含參構造器創建線程物件。
    4. 將Runnable接口的子類物件作為實際參數傳遞給Thread類的構造器中。
    5. 調用Thread類的start方法：開啟線程，調用Runnable子類接口的run方法。


    比較創建線程的兩種方式:
    開發中: 我們優先考慮用Runnable去實現。
    原因: 1. 實現的方式沒有類的侷限性。
         2.實現的方式更適合用來處裡多個線程共享數據的狀況。

    聯繫: public class Thread implements Runnable
    相同點:兩者皆需要重寫run方法。


 */


public class RunnableIntro {
    public static void main(String[] args) {
        //3. 通過Thread類含參構造器創建線程物件。
        MyRunnable r1 = new MyRunnable();
        //4. 將Runnable接口的子類物件作為實際參數傳遞給Thread類的構造器中。
        Thread t1 = new Thread(r1);
        //5. 調用Thread類的start方法：(1)開啟線程(2)調用Runnable子類接口的run()。
        t1.start();

        //當Runnable要在啟動一個線程時,可以共用一個實現類物件
        Thread t2 = new Thread(r1);
        t2.start();
    }
}
//1. 定義子類，實現Runnable接口。
class MyRunnable implements Runnable{
    //2. 子類中重寫Runnable接口中的run方法。
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 5 == 0) {
                //使用Runnable的類中要調用Thread的方法需要顯式使用。
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
