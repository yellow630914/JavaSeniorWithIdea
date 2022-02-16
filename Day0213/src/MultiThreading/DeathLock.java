package MultiThreading;
/*
    演示現成死鎖

    死鎖:
    不同的線程分別佔用對方需要的同步資源不放棄，都在等待對方放棄
     自己需要的同步資源，就形成了線程的死鎖
    出現死鎖後，不會出現異常，不會出現提示，只是所有的線程都處於
     阻塞狀態，無法繼續
    解決方法:
    專門的算法、原則
    盡量減少同步資源的定義
    盡量避免嵌套同步

 */
public class DeathLock {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        new Thread(() -> {
            synchronized (s1){
                s1.append("a");
                s2.append("1");

                //提高死鎖機率
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (s2){
                    s1.append("b");
                    s2.append("2");

                    System.out.println(s1);
                    System.out.println(s2);
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (s2){
                s1.append("a");
                s2.append("1");

                synchronized (s1){
                    s1.append("b");
                    s2.append("2");

                    System.out.println(s1);
                    System.out.println(s2);
                }
            }
        }).start();
    }
}
