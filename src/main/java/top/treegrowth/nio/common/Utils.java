package top.treegrowth.nio.common;

import java.lang.reflect.Method;
import java.nio.Buffer;

public class Utils {

    @SuppressWarnings("uncheck")
    public static <T extends Buffer> void printAll(T t) throws Exception {
        Class clazz = t.getClass();
        Method get = clazz.getMethod("get", null);
        get.setAccessible(true);
        while (t.hasRemaining()) {
            System.out.print(get.invoke(t, null));
        }
        System.out.println();
        System.out.println("========");
    }
}
