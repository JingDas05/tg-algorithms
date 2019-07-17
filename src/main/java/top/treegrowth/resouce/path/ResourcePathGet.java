package top.treegrowth.resouce.path;

import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.net.URL;

/**
 *
 * resource文件夹下路径获取
 *
 * @author wusi
 * @since 2019-07-17 11:55
 */
public class ResourcePathGet {

    public static void main(String[] args) throws FileNotFoundException {
        URL url = ResourceUtils.getURL(ResourceUtils.CLASSPATH_URL_PREFIX + "test/bean.xml");
        System.out.println(url);
    }
}
