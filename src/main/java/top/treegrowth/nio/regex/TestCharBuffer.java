package top.treegrowth.nio.regex;

import java.nio.CharBuffer;

/**
 * @author wusi
 * @version 2017/3/19 11:55.
 */
public class TestCharBuffer {
    public static void main(String[] argv) {

        CharBuffer charBuffer = CharBuffer.allocate(20);

        charBuffer.put("xxxxxxxxxxxxxxxxxxxx");
//        printBasecInfo(charBuffer);
        charBuffer.clear();
//        printBasecInfo(charBuffer);
//        printCharSequence(charBuffer);
//        printBasecInfo(charBuffer);

        charBuffer.put("Hello World");
//        printBasecInfo(charBuffer);
        charBuffer.flip();
//        printBasecInfo(charBuffer);


        //经过上面的flip,position = 0, limit = 11,下面调用mark 使mark = position = 0;
        charBuffer.mark();
//        printBasecInfo(charBuffer);
        //经过下面put之后position 变成5
        charBuffer.put("Seeya");
//        printBasecInfo(charBuffer);
        //下面的reset方法使当前的position  = mark = 0;
        charBuffer.reset();
//        printBasecInfo(charBuffer);
        printCharSequence(charBuffer);
//
        charBuffer.clear();
//        printCharSequence (charSequence);
//         changing underlying CharBuffer is reflected in the
//         read-only CharSequnce interface.
    }

    private static void printBasecInfo(CharBuffer cb) {
        System.out.println("capacity:" + cb.capacity() + ",position:" + cb.position() + ",limit:" + cb.limit());
    }

    private static void printCharSequence(CharSequence cs) {
        System.out.println("length=" + cs.length()
                + ", content='" + cs.toString() + "'");
    }
}
