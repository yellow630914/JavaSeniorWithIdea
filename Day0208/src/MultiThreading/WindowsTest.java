package MultiThreading;

/*
    with Thread
    例子:三個窗口賣票,票總數為100張

 */

public class WindowsTest {
    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}

class Window extends Thread{
    private static int ticket = 100;

    @Override
    public void run() {
        while (true){
            if(ticket > 0){
                System.out.println(getName() + ":賣票,票號為: " + ticket--);
            }else {
                break;
            }
        }
    }
}
