/*
    URL类:
        URL(Uniform Resource Locator)：统一资源定位符，它表示 Internet 上某一
        资源的地址。
        它是一种具体的URI，即URL可以用来标识一个资源，而且还指明了如何locate
        这个资源。
        通过 URL 我们可以访问 Internet 上的各种网络资源，比如最常见的 www，ftp
        站点。浏览器通过解析给定的 URL 可以在网络上查找相应的文件或其他资源。
         URL的基本结构由5部分组成：
        <传输协议>://<主机名>:<端口号>/<文件名>#片段名?参数列表
            例如:
            http://192.168.1.100:8080/helloworld/index.jsp#a?username=shkstart&password=123
            #片段名：即锚点，例如看小说，直接定位到章节
            参数列表格式：参数名=参数值&参数名=参数值....

        为了表示URL，java.net 中实现了类 URL。我们可以通过下面的构造器来初始化一个 URL 对象：
            public URL (String spec)：通过一个表示URL地址的字符串可以构造一个URL对象。例
            如：URL url = new URL ("http://www. atguigu.com/");
            public URL(URL context, String spec)：通过基 URL 和相对 URL 构造一个 URL 对象。
            例如：URL downloadUrl = new URL(url, “download.html")
            public URL(String protocol, String host, String file); 例如：new URL("http",
            "www.atguigu.com", “download. html");
            public URL(String protocol, String host, int port, String file); 例如: URL gamelan = new
            URL("http", "www.atguigu.com", 80, “download.html");
         URL类的构造器都声明抛出非运行时异常，必须要对这一异常进行处理，通常是用 try-catch 语句进行捕获。

 */

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class URLIntro {
    @Test
    public void testURL1(){
        try {
            URL url = new URL("http://localhost:8080/examples/beauty.jpg?usernmae=jjjj123&password=123123");

            System.out.println(url.getProtocol());

            System.out.println(url.getHost());

            System.out.println(url.getPort());

            System.out.println(url.getPath());

            System.out.println(url.getPath());

            System.out.println(url.getFile());

            System.out.println(url.getQuery());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
