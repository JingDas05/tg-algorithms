package top.treegrowth.java.move;

/**
 * @author wusi
 * @version 2017/10/12 17:47
 */
public class PrimitiveParamMoveTest {

    // 正数首位为0，负数为1
    public static void main(String[] args) {
        int i = -4;
        System.out.println(i);
        System.out.println(Integer.toBinaryString(i));
        System.out.println("有符号右移移位后1位");
        i >>=1;
        System.out.println(i);
        System.out.println(Integer.toBinaryString(i));
        System.out.println("===================================================================");
        i = -4;
        System.out.println(i);
        System.out.println(Integer.toBinaryString(i));
        System.out.println("无符号右移移位后1位");
        i >>>=1;
        System.out.println(i);
        System.out.println(Integer.toBinaryString(i));
        System.out.println("===================================================================");
        // 对于short类来说，由于short只占2Byte,在移位操作时会先转换为int类型，虽然在高位补1，但当把运算结果
        // 再赋值给short类型变量时，只会取其中的低位两字节，因此无论补0还是补1对运算结果无影响
        short j = -4;
        System.out.println(j);
        System.out.println(Integer.toBinaryString(j));
        System.out.println("无符号右移移位后1位");
        j >>>=1;
        System.out.println(j);
        System.out.println(Integer.toBinaryString(j));
        System.out.println("===================================================================");
        i = 5;
        System.out.println(i);
        System.out.println(Integer.toBinaryString(i));
        System.out.println("有符号右移移位后32位");
        i >>>=32;
        System.out.println(i);
        System.out.println(Integer.toBinaryString(i));
    }
}
