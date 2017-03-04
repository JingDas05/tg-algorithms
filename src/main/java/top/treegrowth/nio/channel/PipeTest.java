package top.treegrowth.nio.channel;

import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Random;

/**
 * @author wusi
 * @version 2017/3/5 7:17.
 */
public class PipeTest {
    public static void main(String[] argv)
            throws Exception {
        // startWork 这个过程新建了一个管道类，传入的是上面的WritableByteChannel，返回的是ReadableByteChannel
        ReadableByteChannel workerChannel = startWorker(10);
        //上面把数据已经写道pipe的里面了，那么下面开始通过sourceChannel读取
        //下面初始化一个channel的载体buffer
        ByteBuffer buffer = ByteBuffer.allocate(100);
        // 配置了一个输出事控制台的 WritableByteChannel
        WritableByteChannel out = Channels.newChannel(System.out);
        while (workerChannel.read(buffer) >= 0) {
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }
    }

    /**
     * 新建了一个Pipe, 之后返回管道的sourceChannel
     */
    private static ReadableByteChannel startWorker(int reps)
            throws Exception {
        Pipe pipe = Pipe.open();
        Worker worker = new Worker(pipe.sink(), reps);

        worker.start();

        return (pipe.source());
    }

    // -----------------------------------------------------------------

    /**
     * 新建了一个work类，参数是 WritableByteChannel， 和随机数
     * 作用是随机生成一个包含指定内容的byteBuffer,调用WritableByteChannel
     * 的write 方法去写这个byteBuffer，去写到哪里并不知道，需要靠传入的
     * WritableByteChannel去配置
     */
    private static class Worker extends Thread {
        WritableByteChannel channel;
        private int reps;

        Worker(WritableByteChannel channel, int reps) {
            this.channel = channel;
            this.reps = reps;
        }

        // thread execution begins here
        public void run() {
            ByteBuffer buffer = ByteBuffer.allocate(100);

            try {
                for (int i = 0; i < this.reps; i++) {
                    doSomeWork(buffer);

                    // channel may not take it all at once
                    while (channel.write(buffer) > 0) {
                        // empty
                    }
                }

                this.channel.close();
            } catch (Exception e) {
                // easy way out, this is demo code
                e.printStackTrace();
            }
        }

        private String[] products = {
                "No good deed goes unpunished",
                "To be, or what?",
                "No matter where you go, there you are",
                "Just say \"Yo\"",
                "My karma ran over my dogma"
        };

        private Random rand = new Random();

        private void doSomeWork(ByteBuffer buffer)
                throws Exception {
            int product = rand.nextInt(products.length);

            buffer.clear();
            buffer.put(products[product].getBytes("US-ASCII"));
            buffer.put("\r\n".getBytes("US-ASCII"));
            buffer.flip();
        }
    }
}
