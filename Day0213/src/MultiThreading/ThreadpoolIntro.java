package MultiThreading;

/*
    創建線程的方式四,線程池:
         背景：經常創建和銷毀、使用量特別大的資源，比如並發情況下的線程，對性能影響很大。
         思路：提前創建好多個線程，放入線程池中，使用時直接獲取，使用完放回池中。可以避免頻繁創建銷毀、實現重複利用。類似生活中的公共交通工具。
         好處：
             提高響應速度（減少了創建新線程的時間）
             降低資源消耗（重複利用線程池中線程，不需要每次都創建）
             便於線程管理
                 corePoolSize：核心池的大小
                 maximumPoolSize：最大線程數
                 keepAliveTime：線程沒有任務時最多保持多長時間後會終止
                 …

 */

import java.util.concurrent.*;

public class ThreadpoolIntro {

    public static void main(String[] args) {
        //1. 提供指定線程數量的線程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        //2.執行指定現成操作。提供Runnable或Callable實現類的物件。
        service.execute(new NumberThreadsWithSeven()); //適合用於Runnable
        FutureTask futureTask = (FutureTask)service.submit(new NumberThreadsWithNine()); //適合用於Callable,submit()返回Future類

        try {
            System.out.println("總合為:" + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //3.關閉線程
        service.shutdown();
    }

}

class NumberThreadsWithSeven implements Runnable{

    @Override
    public void run() {
        Thread.currentThread().setName("7的公倍數");
        for (int i = 0; i < 100; i++) {
            if(i % 7 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class NumberThreadsWithNine implements Callable {
    private int sum = 0;

    @Override
    public Object call() throws Exception {
        Thread.currentThread().setName("9的公倍數");
        for (int i = 0; i < 100; i++) {
            if(i % 9 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
                sum += i;
            }
        }
        return sum;
    }
}
