package MultiThreading;

/*
     with Runnable
     例子:三個窗口賣票,票總數為100張

 */

public class RunnableWindowsTest {
    public static void main(String[] args) {
        WindowsWithRunnable w = new WindowsWithRunnable();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.start();
        t2.start();
        t3.start();
    }
}


class WindowsWithRunnable implements Runnable{

    private int ticket = 100;

    @Override
    public void run() {
        while(true){
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName()+":賣票,票號為: " + ticket--);
            }else{
                break;
            }
        }
    }
}