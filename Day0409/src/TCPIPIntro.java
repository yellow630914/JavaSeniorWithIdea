/*
    TCP 和 UDP

     TCP协议(下載檔案,重要數據傳輸)：
         使用TCP协议前，须先建立TCP连接，形成传输数据通道
     !!! 传输前，采用“三次握手”方式，点对点通信，是可靠的!!!
         TCP协议进行通信的两个应用进程：客户端、服务端。
         在连接中可进行大数据量的传输
         传输完毕，需释放已建立的连接，效率低
         四次揮手,確保連接斷開。
     UDP协议(可運用於直播,影片等等)：
         将数据、源、目的封装成数据包，!!!不需要建立连接!!!
         每个数据报的大小限制在64K内
         发送不管对方是否准备好，接收方收到也不确认，故是不可靠的
         可以广播发送
         发送数据结束时无需释放资源，开销小，速度快

 */


import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPIPIntro {

    /*
    實現TCP網路編程:
    例子1: 客戶端發送信息給服務端,服務端將數據顯示在控制台上

     */

    //客戶端
    @Test
    public void client1(){
        Socket socket = null;
        OutputStream os = null;
        try {
            //1.創建Socket物件,指名服務器ip與端口
            InetAddress inet = InetAddress.getByName("127.0.0.1");//對方的IP
            socket = new Socket(inet,8899);
            //2.獲取一個輸出流,用於輸出數據
            os = socket.getOutputStream();
            //3.寫出數據操作
            os.write("你好,我是客戶端".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //資源關閉
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //服務端
    @Test
    public void server1(){
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        ServerSocket ss = null;
        try {
            //1.創建ServerSocket服務器,指名自身服務器端口
            ss = new ServerSocket(8899);
            //2.調用accept()表示接收來自客戶端的socket
            socket = ss.accept();
            //3.獲取輸入流
            is = socket.getInputStream();

            //4.解析取得的socket
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = is.read(buffer)) != -1){
                baos.write(buffer,0,len);
            }
            System.out.println(baos);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5.關閉資源
            if (baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /*
    例子2: 客戶端發送文件給服務端,服務端將文件保存在本地

     */

    @Test
    public void client2(){
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9298);

            os = socket.getOutputStream();

            fis = new FileInputStream(new File("forest.jpg"));

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1){
                os.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void server2(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            ss = new ServerSocket(9298);

            socket = ss.accept();

            is = socket.getInputStream();

            fos = new FileOutputStream(new File("ELforest.jpg"));

            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    /*
    例子3: 客戶端發送文件給服務端,服務端將文件保存在本地。並返回"發送成功給客戶端"。關閉連接。

     */
    @Test
    public void client3(){
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9298);

            os = socket.getOutputStream();

            fis = new FileInputStream(new File("forest.jpg"));

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1){
                os.write(buffer,0,len);
            }
            socket.shutdownOutput();

            //接收服務器上的數據,並顯示
            InputStream is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] buffer20 = new byte[20];
            int len20;
            while((len20 = is.read(buffer20)) != -1){
                baos.write(buffer20,0,len20);
            }
            System.out.println(baos);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void server3(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        OutputStream os = null;
        try {
            ss = new ServerSocket(9298);

            socket = ss.accept();

            is = socket.getInputStream();

            fos = new FileOutputStream(new File("ELforest.jpg"));

            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }

            //6.服務器給客戶端的反饋
            os = socket.getOutputStream();
            os.write("創建完成".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
