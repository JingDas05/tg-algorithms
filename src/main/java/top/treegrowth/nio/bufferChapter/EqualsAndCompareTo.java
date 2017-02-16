package top.treegrowth.nio.bufferChapter;

import java.nio.ByteBuffer;

public class EqualsAndCompareTo {

    public static void main(String[] args) {
        //位置为limit的值不返回
        ByteBuffer[] byteBuffers = equalsInit();
        ByteBuffer[] byteBuffers1 = compareInit();
        ByteBuffer b1 = byteBuffers[0];
        ByteBuffer b2 = byteBuffers[1];

        ByteBuffer b3 = byteBuffers1[0];
        ByteBuffer b4 = byteBuffers1[1];
        while (b1.hasRemaining()) {
            System.out.println(b1.get());
        }

        //验证equals 和compare
        System.out.println(b1.equals(b2));
        System.out.println(b1.compareTo(b2));
        System.out.println(b3.equals(b4));
        System.out.println(b3.compareTo(b4));
    }

    public static ByteBuffer[] equalsInit() {

        ByteBuffer[] byteBuffers;
        ByteBuffer b1 = ByteBuffer.allocate(20);
        ByteBuffer b2 = ByteBuffer.allocate(20);

        b1.put((byte) 'd').put((byte) 'e').put((byte) '3').put((byte) 'o').put((byte) 'm').put((byte) 's').put((byte) 'p');
        b1.position(2).limit(5);
        b2.put((byte) '3').put((byte) 'o').put((byte) 'm').put((byte) '4').put((byte) '5').put((byte) '6');
        b2.limit(3);

        byteBuffers = new ByteBuffer[]{b1, b2};
        return byteBuffers;
    }

    public static ByteBuffer[] compareInit() {

        ByteBuffer[] byteBuffers;
        ByteBuffer b1 = ByteBuffer.allocate(20);
        ByteBuffer b2 = ByteBuffer.allocate(20);

        b1.put((byte) 'c').put((byte) 'o').put((byte) 'm').put((byte) '3').put((byte) 'd').put((byte) 'y');
        b2.put((byte) 'c').put((byte) 'o').put((byte) 'm').put((byte) '3').put((byte) 'd').put((byte) 'y');
        b2.position(2);

        byteBuffers = new ByteBuffer[]{b1, b2};
        return byteBuffers;
    }
}
