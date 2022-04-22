/*
    靜態代理範例:當代理類與被代理類是確定的時

 */


public class ProxyTest {
    public static void main(String[] args) {
        ClothFactory uni = new UniClothFactory();

        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(uni);

        proxyClothFactory.produceCloth();
    }


}


interface ClothFactory{
    void produceCloth();
}

//代理類
class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory;//用被代理類對象進行實例化

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工廠準備中");

        factory.produceCloth();

        System.out.println("代理工廠結束中");
    }
}

//被代理類
class UniClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Uni生產中");
    }
}
