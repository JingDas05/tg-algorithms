package top.treegrowth.nio.bufferChapter;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * @author wusi
 * @version 017/2/13.
 */
public class BufferStudy {

    public static void main(String[] args) {

        System.out.println(bufferFillin());
    }

    public static Buffer bufferFillin() {

        ByteBuffer buffer = ByteBuffer.allocate(100);
        buffer.put((byte) 'h').put(((byte)'e')).put(((byte)'l')).put(((byte)'l')).put(((byte)'o'));
        return buffer;
    }
}
