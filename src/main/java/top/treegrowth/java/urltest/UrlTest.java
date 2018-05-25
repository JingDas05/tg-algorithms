package top.treegrowth.java.urltest;

import java.net.URL;

/**
 * @author Administrator
 */
public class UrlTest {

    public static void main(String[] args) throws Exception{
        URL url = new URL("http://treegrowth.top?key1=0&key2=3");
        System.out.println(url.getHost());
        System.out.println(url.getQuery());
        System.out.println(url.getPath());
    }
}
