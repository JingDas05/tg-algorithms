package top.treegrowth.nio.bufferChapter;


import java.nio.CharBuffer;

import static top.treegrowth.nio.common.Utils.printAll;

/**
 * @version 2017/2/15.
 */
public class CharBufferSlice {

    public static void main(String[] args) {
        try {
            testCharBufferSlice();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testCharBufferSlice() throws Exception {

        char[] chars = new char[]{'a', 'b', 'm', 'n', 'p'};
        CharBuffer charBuffer = CharBuffer.wrap(chars);
        //put 会导致position自增，put加index不会导致position 自增
        charBuffer.put(0, 'x');
        printAll(charBuffer);
        charBuffer.position(1).limit(3).mark();
        //slice 会截取position 到 limit 之间的元素，包括position， 不包括limit的元素
        CharBuffer sliceCharBuffer = charBuffer.slice();
        printAll(sliceCharBuffer);
        //修改数组chars，查看charBuffer 与sliceCharBuffer 的变化
        chars[1] = 'y';
        //charBuffer 为 y m
        printAll(charBuffer);
        //经过上一个printAll打印position自加 此时 下面的sliceCharBuffer打印不出来东西了
        printAll(sliceCharBuffer);
        //经过重新设置就好了
        sliceCharBuffer.position(0).limit(sliceCharBuffer.length());
        printAll(sliceCharBuffer);
    }
}
