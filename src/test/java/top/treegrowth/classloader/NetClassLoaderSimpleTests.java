package top.treegrowth.classloader;

import top.treegrowth.utils.CusNetworkClassLoader;

/**
 *
 * 测试没有通过，没有走cusNetworkClassLoader里的方法，应该事spring boot 的问题
 * @author wusi
 * @version 2017/2/19 9:50.
 */
public class NetClassLoaderSimpleTests {

    public static void main(String[] args) {
        try {
            testIsSameClass();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void testIsSameClass() throws Exception{
        String rootUrl = "http://localhost:8080/classes";
        String className = "top.treegrowth.classloader.NetClassLoaderSimple";
        CusNetworkClassLoader n1 = new CusNetworkClassLoader(rootUrl);
        CusNetworkClassLoader n2 = new CusNetworkClassLoader(rootUrl);

        Class<?> clazz1 = n1.loadClass(className);
        Class<?> clazz2 = n2.loadClass(className);

        Object b1 = clazz1.newInstance();
        Object b2 = clazz2.newInstance();

        //通过反射获取方法，invoke(context, args);context是第一个bean的势实例，
        //注入的是第二个实例
        clazz1.getMethod("setNetClassLoaderSimple", Object.class).invoke(b1, b2);

    }
}
