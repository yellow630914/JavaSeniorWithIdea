package MultiThreading;

/*
    創建線程的方式三,Callable接口: --------jdk 5.0

     與使用Runnable相比， Callable功能更強大些
         相比run()方法，call()可以有返回值
         call()方法可以拋出異常
         call支持泛型的返回值
         需要藉助FutureTask類，比如獲取返回結

 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableIntro {
    public static void main(String[] args) {
        //3.創建Callable接口實現類的物件。
        NumThread nt = new NumThread();
        //4.將此Callable接口實現類的物件傳遞到FutureTask構造器中,創建FutureTask物件。
        FutureTask futureTask = new FutureTask(nt);
        //5.將FutureTask的物件傳遞到Thread構造器中創建Thread物件,並start。
        Thread t1 = new Thread(futureTask);
        t1.start();

        try {
            //get()返回值即為,Callable實現類中的call()返回值。
            Object sum = futureTask.get();
            System.out.println("總合為:" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

//1.創建一個Callable接口的實現類。
class NumThread implements Callable{

    private int sum = 0;

    //重寫Callable接口的,call()方法。
    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 100; i++) {
            getFiveMod(i);
        }
        return sum;
    }

    private synchronized void getFiveMod(int inputInteger){
        if(inputInteger % 5 == 0){
            System.out.println(inputInteger);
            sum += inputInteger;
        }
    }
}
