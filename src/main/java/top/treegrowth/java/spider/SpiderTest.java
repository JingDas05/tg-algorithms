package top.treegrowth.java.spider;

import top.treegrowth.io.buffer.FileOperator;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author wusi
 * @version 2019/1/4 10:42.
 */
public class SpiderTest {

    public static void main(String[] args) throws Exception {
        String sourceContent = getURLContent("http://www.shicimingju.com/chaxun/list/29694.html");
        if (sourceContent != null) {
            // 去除空格
            sourceContent = sourceContent.replace(" ", "");
            // 查找位置
            int beginIndex = sourceContent.indexOf("<divclass=\"shici-content\">");
            // 截取
            String target = sourceContent.substring(beginIndex + 26, beginIndex + 86);
            // 换行
            String[] splitContent = target.split("<br>");
            FileOperator.write(splitContent);
        }

    }

    // 获取网页内容
    private static String getURLContent(String urlStr) {
        URL url = null;
        HttpURLConnection httpConn = null;
        BufferedReader in = null;
        StringBuilder content = new StringBuilder();
        try {
            url = new URL(urlStr);
            in = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            String str = null;
            while ((str = in.readLine()) != null) {
                content.append(str);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        String result = content.toString();
        System.out.println(result);
        return result;
    }
}
