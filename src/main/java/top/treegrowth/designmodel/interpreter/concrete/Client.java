package top.treegrowth.designmodel.interpreter.concrete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wusi
 * @version 2017/3/15 13:29
 */
public class Client {

    public static void main(String[] args) throws IOException {
        String expStr = getStr();
        Map<String, Integer> ctx = getValue(expStr);
        Calculator calculator = new Calculator(expStr);
        System.out.println("计算的结果是" + calculator.run(ctx));
    }

    public static String getStr() throws IOException {
        System.out.println("输入表达式");
        return new BufferedReader(new InputStreamReader(System.in)).readLine();
    }

    public static Map<String, Integer> getValue(String expression) throws IOException {
        Map<String, Integer> ctx = new HashMap<>();
        for (char c : expression.toCharArray()) {
            if (c != '+' && c != '-') {
                //解决参数重复的问题
                if (!ctx.containsKey(String.valueOf(c))) {
                    System.out.println("输入" + c + "的值");
                    Integer value = new BufferedReader(new InputStreamReader(System.in)).read();
                    ctx.put(String.valueOf(c), value);
                }
            }
        }
        return ctx;
    }
}
