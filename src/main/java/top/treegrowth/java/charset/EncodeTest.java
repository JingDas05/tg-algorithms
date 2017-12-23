package top.treegrowth.java.charset;

import java.io.UnsupportedEncodingException;

/**
 * @author wusi
 * @version 2017/12/16 7:42.
 */
public class EncodeTest {

    public static void main(String[] args) {
        String name = "I am 君山";

        try {
            byte[] iso8859 = name.getBytes("ISO-8859-1");

            byte[] gb2312 = name.getBytes("GB2312");

            byte[] gbk = name.getBytes("GBK");

            byte[] utf16 = name.getBytes("UTF16");

            byte[] utf8 = name.getBytes("UTF8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public char[] toHex(String str) {
       return str.toCharArray();
    }
}
