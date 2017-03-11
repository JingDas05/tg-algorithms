package top.treegrowth.nio.channel.socketchannel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SocketChannel;

/**
 * @author wusi
 * @version 2017/2/25 10:25.
 */
public class SocketConnetClient {

    public static void main(String[] args) throws IOException {

        String host = "localhost";
        int port = 1234;

        InetSocketAddress addr = new InetSocketAddress(host, port);
        SocketChannel sc = SocketChannel.open();
        //如果下面这句加上会产生一个异常，IllegalBlockingModeException？？？？
        //sc.configureBlocking(false);
        System.out.println("initiating connection");
        sc.connect(addr);
        while (!sc.finishConnect()) {
            doSomethingUseful();
        }
        System.out.println("connect established");
        Socket socket = sc.socket();
        //打印从服务器获取的socket字段, 也是结合Class SelectSockets的客户端
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(bufferedReader.readLine());
        sc.close();
    }

    public static void doSomethingUseful() {
        System.out.println("打打酱油");
    }
}
