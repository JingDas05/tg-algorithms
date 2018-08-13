package top.treegrowth.java.classloader;

import java.io.*;
import java.net.URL;
import java.util.Enumeration;

/**
 * @author wusi
 * @version 2018/8/13.
 */
public class GetResourcesTest {

    public static void main(String[] args) throws Exception {
        // 获取项目根路径
        Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources("");
        System.out.println(resources.hasMoreElements() ? resources.nextElement() : "not find");
        // 获取项目根路径下的资源
        Enumeration<URL> resources1 = Thread.currentThread().getContextClassLoader().getResources("classloader/test.txt");
        System.out.println(resources1.hasMoreElements() ? "find" : "not find");
        URL resources1Url = resources1.nextElement();
        BufferedReader bReader = null;
        String line = null;
        try {
            bReader = new BufferedReader(new InputStreamReader(resources1Url.openStream()));
            while ((line = bReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 获取class文件所在的路径
        System.out.println(GetResourcesTest.class.getResource(""));
        // 获取项目的根路径
        System.out.println(GetResourcesTest.class.getResource("/"));
    }
}
