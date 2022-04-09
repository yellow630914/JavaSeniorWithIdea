/*
    网络基础

    计算机网络：
    把分布在不同地理区域的计算机与专门的外部设备用通信线路互连成一个规
    模大、功能强的网络系统，从而使众多的计算机可以方便地互相传递信息、
    共享硬件、软件、数据信息等资源。

    网络编程的目的：
    直接或间接地通过网络协议与其它计算机实现数据交换，进行通讯。

    网络编程中有两个主要的问题：
        如何准确地定位网络上一台或多台主机；定位主机上的特定的应用
             通信双方地址
                 IP
                 端口号
        找到主机后如何可靠高效地进行数据传输
             一定的规则（即：网络通信协议。有两套参考模型）
                 OSI参考模型：模型过于理想化，未能在因特网上进行广泛推广
                 TCP/IP参考模型(或TCP/IP协议)：事实上的国际标准。
 */


import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InternetWithJava {
    /*

    IP與域名與InetAddress:
        IP 地址：InetAddress
            唯一的标识 Internet 上的计算机（通信实体）
            本地回环地址(hostAddress)：127.0.0.1      主机名(hostName)：localhost
            IP地址分类方式1：IPV4 和 IPV6
                IPV4：4个字节组成，4个0-255。大概42亿，30亿都在北美，亚洲4亿。2011年初已
                经用尽。以点分十进制表示，如192.168.0.1
                IPV6：128位（16个字节），写成8个无符号整数，每个整数用四个十六进制位表示，
                数之间用冒号（：）分开，如：3ffe:3201:1401:1280:c8ff:fe4d:db39:1984
            IP地址分类方式2：公网地址(万维网使用)和私有地址(局域网使用)。192.168.
             开头的就是私有址址，范围即为192.168.0.0--192.168.255.255，专门为组织机
             构内部使用
            特点：不易记忆

        域名:域名容易记忆，当在连接网络时输入一个主机的域名后，域名服务器(DNS)
            负责将域名转化成IP地址，这样才能和主机建立连接。 -------域名解析

        InetAddress:
            Java中實例化IP的類:
                getByName(String host)、getLocalHost()
            常用方法:getHostName()/getHostAddress()

    */
    @Test
    public void testIP(){
        try {
            //File file = new File("Path");
            //InetAddress inet1 = new InetAddress.getByName("IP");
            InetAddress inet1 = InetAddress.getByName("192.168.10.25");

            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getByName("www.gamer.com.tw");
            System.out.println(inet2);

            InetAddress inet3 = InetAddress.getByName("127.0.0.1");
            System.out.println(inet3);

            System.out.println(InetAddress.getLocalHost());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    /*

    端口:
        端口号标识正在计算机上运行的进程（程序）
             不同的进程有不同的端口号
             被规定为一个 16 位的整数 0~65535。
             端口分类：
                 公认端口：0~1023。被预先定义的服务通信占用（如：HTTP占用端口
                  80，FTP占用端口21，Telnet占用端口23）
                 注册端口：1024~49151。分配给用户进程或应用程序。（如：Tomcat占
                  用端口8080，MySQL占用端口3306，Oracle占用端口1521等）。
                 动态/私有端口：49152~65535。
        端口号与IP地址的组合得出一个网络套接字：Socket。

     */
}
