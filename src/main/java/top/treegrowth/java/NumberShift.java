package top.treegrowth.java;

/**
 * 左移运算符与右移运算符，无符号右移
 *
 * @author wusi
 * @version 2017/6/11 20:49.
 */
public class NumberShift {

    public static void main(String[] args) {
        // 结果1 右移运算符
        System.out.println(2 >> 1);
        // 结果16 左移运算符
        System.out.println(1 << 4);
        // 结果 2
        System.out.println(16 >>> 3);
        // 整数是4个字节，所以忽略前面的0, 16是 10000
        System.out.println(Integer.toBinaryString(16));
        // 整数是4个字节，所以 -16 是11111111111111111111111111110000
        System.out.println(Integer.toBinaryString(-16));
        // 无符号右移的规则只记住一点：忽略了符号位扩展，0补最高位, 移动之后是11111111111111111111111111110
        System.out.println(Integer.toBinaryString(-16 >>> 3));
    }
}
