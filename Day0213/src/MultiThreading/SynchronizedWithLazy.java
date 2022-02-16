package MultiThreading;

public class SynchronizedWithLazy {
}


class Bank{
    private Bank(){

    }

    private  static Bank instance = null; //共享數據

    //使用synchronized達成線程安全
    public static Bank getInstance(){
        if(instance == null){
            //雙判斷式可以防止線程塞車
            synchronized (Bank.class){
                //若是沒有使用同步鎖,在多線程的場景下,可能造成單例模式被破壞。
                if(instance == null){
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}