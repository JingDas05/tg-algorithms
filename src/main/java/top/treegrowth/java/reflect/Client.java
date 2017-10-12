package top.treegrowth.java.reflect;

import java.lang.reflect.Method;

/**
 * @author wusi
 * @version 2017/10/11 7:22.
 */
public class Client {

    public static void main(String[] args) throws Exception {
        Class<TargetClass> clazz = TargetClass.class;
        Method method = clazz.getMethod("method1", String.class);
        method.getDeclaringClass();

        //getDeclaringClass 方法会返回当前方法所在类的class对象！！！！！

        Class<TargetInterface> clazzInterface = TargetInterface.class;
        Class<ParentInterface> clazzParentInterface = ParentInterface.class;
        Method testMethod = clazzInterface.getMethod("testMethod");
        Method testMethodParent = clazzInterface.getMethod("testMethodParent");
        System.out.println(testMethod.getDeclaringClass().equals(clazzInterface));
        System.out.println(testMethodParent.getDeclaringClass().equals(clazzParentInterface));

        // clazzInterface.getInterfaces() 会获取clazzInterface的所有直接父接口
        for (Class<?> each : clazzInterface.getInterfaces()) {
            System.out.println(each);
            System.out.println(clazzInterface.isAssignableFrom(each));
        }
    }
}
