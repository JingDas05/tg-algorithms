package top.treegrowth.nio.channel;

import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author wusi
 * @version 2017/2/25 9:19.
 */
public class HelloSocket {

    //实现定义读和写的功能接口
    DatagramChannel datagramChannel;
    SocketChannel socketChannel;

    //负责监听传入的连接和创建新的SocketChannel对象
    ServerSocketChannel serverSocketChannel;

    //socket adress
    InetSocketAddress inetSocketAddress;


}
