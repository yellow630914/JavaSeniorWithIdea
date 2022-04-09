/*
UDP网络通信:
     类 DatagramSocket 和 DatagramPacket 实现了基于 UDP 协议网络程序。
     UDP数据报通过数据报套接字 DatagramSocket 发送和接收，系统不保证
    UDP数据报一定能够安全送到目的地，也不能确定什么时候可以抵达。
     DatagramPacket 对象封装了UDP数据报，在数据报中包含了发送端的IP
    地址和端口号以及接收端的IP地址和端口号。
     UDP协议中每个数据报都给出了完整的地址信息，因此无须建立发送方和
    接收方的连接。如同发快递包裹一样。

 */

import org.junit.Test;

import java.io.IOException;
import java.net.*;

public class UDPIntro {
    @Test
    public void sender(){

        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();

            String str = "我是UDP子彈";
            byte[] data = str.getBytes();
            InetAddress inet = InetAddress.getLocalHost();
            DatagramPacket packet = new DatagramPacket(data,0,data.length,inet,9092);

            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(socket != null){
                socket.close();
            }
        }


    }

    @Test
    public void receiver() throws IOException {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(9092);

            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);

            socket.receive(packet);

            System.out.println(new String(packet.getData(),0, packet.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(socket != null){
                socket.close();
            }
        }


    }
}
