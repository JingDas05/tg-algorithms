package top.treegrowth.algorithms.reflection;

import top.treegrowth.algorithms.common.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {

    private static String name = "top.treegrowth.algorithms.common.Utils";

    public static void main(String... args) {
        Class<?> c1 = null;
        Utils utils1;
        Utils utils2;
        try {
            c1 = Class.forName(name);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        try {
            Method[] methods = c1.getMethods();
            utils1 = (Utils) c1.newInstance();
            utils2 = (Utils) c1.newInstance();
            System.out.println(utils1);
            System.out.println(utils1);
            for (Method method : methods) {
                if (method.getName().equals("testPrint"))
                    method.invoke(utils1, 1);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        System.out.print(c1);
        c1.getAnnotations();
        c1.getFields();
        c1.getInterfaces();
    }
}
