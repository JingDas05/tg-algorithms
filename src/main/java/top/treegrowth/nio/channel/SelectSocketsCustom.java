package top.treegrowth.nio.channel;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * 测试select为多个通道提供服务，哪个通道有空闲就用哪个通道
 *
 * @author wusi
 * @version 2017/3/14 22:16.
 */
public class SelectSocketsCustom {
    public static int PORT_NUMBER = 1234;

    public static void main(String[] argv) throws Exception {
        new SelectSocketsCustom().go(argv);
    }

    public void go(String[] argv) throws Exception {
        int port = PORT_NUMBER;

        //如果参数传进来，就用传进来的端口号
        if (argv.length > 0) {
            port = Integer.parseInt(argv[0]);
        }

        System.out.println("Listening on port " + port);

        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverChannel.socket();
        Selector selector = Selector.open();

        serverSocket.bind(new InetSocketAddress(port));

        serverChannel.configureBlocking(false);

        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            // 这个地方会阻塞很长时间，直到有一个通道处于准备好的状态
            int n = selector.select();
            if (n == 0) {
                continue;
            }
            Iterator it = selector.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey key = (SelectionKey) it.next();
                // 判断是否有一个新的连接进来了
                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel channel = server.accept();
                    registerChannel(selector, channel, SelectionKey.OP_READ);
                    sayHello(channel);
                }

                // 判断通道上是否有数据可读
                if (key.isReadable()) {
                    readDataFromSocket(key);
                }
                it.remove();
            }
        }
    }

    /**
     * 注册通道到选择器，并且指定了操作类型 ops
     */
    protected void registerChannel(Selector selector, SelectableChannel channel, int ops) throws Exception {
        if (channel == null) {
            return;
        }
        channel.configureBlocking(false);
        channel.register(selector, ops);
    }

    //全局用了一个byteBuffer, 因为是单线程，所以是线程安全的
    private ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

    /**
     * Sample data handler method for a channel with data ready to read.
     *
     * @param key A SelectionKey object associated with a channel
     *            determined by the selector to be ready for reading.  If the
     *            channel returns an EOF condition, it is closed here, which
     *            automatically invalidates the associated key.  The selector
     *            will then de-register the channel on the next select call.
     */
    protected void readDataFromSocket(SelectionKey key) throws Exception {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        int count;
        buffer.clear();
        // loop while data available, channel is non-blocking
        while ((count = socketChannel.read(buffer)) > 0) {
            buffer.flip();        // make buffer readable

            // send the data, don't assume it goes all at once
            while (buffer.hasRemaining()) {
                socketChannel.write(buffer);
            }
            // WARNING: the above loop is evil.  Because
            // it's writing back to the same non-blocking
            // channel it read the data from, this code can
            // potentially spin in a busy loop.  In real life
            // you'd do something more useful than this.

            buffer.clear();        // make buffer empty
        }

        if (count < 0) {
            // close channel on EOF, invalidates the key
            socketChannel.close();
        }
    }

    /**
     * 向新连接的通道发送问候
     *
     * @param channel 新连接通道
     */
    private void sayHello(SocketChannel channel) throws Exception {
        buffer.clear();
        buffer.put("Hi there!\r\n".getBytes());
        buffer.flip();
        channel.write(buffer);
    }

}

