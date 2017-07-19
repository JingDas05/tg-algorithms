package top.treegrowth.designmodel.interpreter.concrete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 单一职责原则
 * 依赖倒置原则
 * 接口隔离原则
 * 迪米特原则
 * 里氏替换原则
 * 开闭原则
 *
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
                    //read 的方法结果不对！！
//                    Integer value =new BufferedReader(new InputStreamReader(System.in)).read();
                    Integer value =Integer.valueOf(new BufferedReader(new InputStreamReader(System.in)).readLine());
                    ctx.put(String.valueOf(c), value);
                }
            }
        }
        return ctx;
    }
}
