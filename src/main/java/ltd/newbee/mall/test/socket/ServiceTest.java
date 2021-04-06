package ltd.newbee.mall.test.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: newbee-mall
 * @description: stock客户端
 * @author: chenshutian
 * @create: 2021-03-17 15:32
 **/
public class ServiceTest {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        OutputStream ops = null;
        try {
            serverSocket = new ServerSocket(8080);
            while (true) {
                socket = serverSocket.accept();
                ops = socket.getOutputStream();
                ops.write("Http/1.1 200 OK \n".getBytes());
                ops.write("Content-Type:text/html;charset=UTF-8;Charset=utf-8\n".getBytes());
                ops.write("Server:Apache-coyote/1.1\n".getBytes());
                ops.write("\n\n".getBytes());
                StringBuffer str = new StringBuffer();
                str.append("<html>");
                str.append("<head><title>我是标题</title></head>");
                str.append("<body>");
                str.append("你好骚啊");
                str.append("<a href  = 'http://baidu.com'>百度</a>");
                str.append("</body>");
                str.append("</html>");
                ops.write(str.toString().getBytes());
                ops.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                ops.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
