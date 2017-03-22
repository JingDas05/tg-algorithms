package top.treegrowth.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author wusi
 * @version 2017/3/22 10:39
 */
public class ReadConfig {

    private static String getXmlString() throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Reader reader = new InputStreamReader(classLoader.getResourceAsStream("target/class开始的路径"), "utf-8");
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuilder stringBuilder = new StringBuilder();
        String strLine = bufferedReader.readLine();
        //循环读取直到读尽
        while (strLine != null) {
            stringBuilder.append(strLine);
            strLine = bufferedReader.readLine();
        }
        return stringBuilder.toString();
    }
}
