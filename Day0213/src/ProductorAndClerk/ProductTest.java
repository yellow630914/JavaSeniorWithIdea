package ProductorAndClerk;

/*
    生產者(Producer)將產品交給店員(Clerk)，而消費者(Customer)從店員處
    取走產品，店員一次只能持有固定數量的產品(比如:20），如果生產者試圖
    生產更多的產品，店員會叫生產者停一下，如果店中有空位放產品了再通
    知生產者繼續生產；如果店中沒有產品了，店員會告訴消費者等一下，如
    果店中有產品了再通知消費者來取走產品。

    分析:
    1.是否是多線程問題? 是,生產者線程,消費這者線程
    2.是否共享數據?是,產品
    3.如何解決現成安全問題?同步機制
    4.是否涉及到線程通信?是
 */

public class ProductTest {
    public static void main(String[] args) {
        Producer p = new Producer();
        Clerk clerk = new Clerk(p);
        Customer customer = new Customer(p);

        Thread clerkThread = new Thread(clerk);
        Thread customerThread = new Thread(customer);

        clerkThread.start();
        customerThread.start();
    }
}

class Producer{

    private int productCount = 0;

    public synchronized void produceProduct(){
        if(productCount < 20){
            productCount++;
            System.out.println(Thread.currentThread().getName() + ":開始生產第" + productCount + "個產品");

            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumeProduct(){
        if(productCount > 0){
            System.out.println(Thread.currentThread().getName() + ":開始消費第" + productCount + "個產品");
            productCount--;

            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Clerk implements Runnable{
    private final Producer producer;

    public Clerk(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void run() {
        while (true){

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            producer.produceProduct();
        }
    }
}

class Customer implements Runnable{
    private final Producer producer;

    public Customer(Producer producer) {
        this.producer = producer;
    }

    public void run(){
        while(true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            producer.consumeProduct();
        }
    }
}