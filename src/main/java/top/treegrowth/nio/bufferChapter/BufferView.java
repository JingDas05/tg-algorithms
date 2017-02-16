package top.treegrowth.nio.bufferChapter;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;

/**
 * @version 2017/2/16.
 */
public class BufferView {

    public static void main (String [] argv)
            throws Exception
    {
        ByteBuffer byteBuffer =
                ByteBuffer.allocate (8).order (ByteOrder.BIG_ENDIAN);
        CharBuffer charBuffer = byteBuffer.asCharBuffer();

        // load the ByteBuffer with some bytes
        byteBuffer.put (0, (byte)0);
        byteBuffer.put (1, (byte)'H');
        byteBuffer.put (2, (byte)0);
        byteBuffer.put (3, (byte)'i');
        byteBuffer.put (4, (byte)0);
        byteBuffer.put (5, (byte)'!');
        byteBuffer.put (6, (byte)'m');
        byteBuffer.put (7, (byte)'m');

        println (byteBuffer);
        println (charBuffer);

        // now slice it differently
        byteBuffer.position (4);
        charBuffer = byteBuffer.asCharBuffer();

        println (byteBuffer);
        println (charBuffer);
    }

    // Print info about a buffer
    private static void println (Buffer buffer)
    {
        System.out.println ("pos=" + buffer.position()
                + ", limit=" + buffer.limit()
                + ", capacity=" + buffer.capacity()
                + ": '" + buffer.toString() + "'");
    }
}
