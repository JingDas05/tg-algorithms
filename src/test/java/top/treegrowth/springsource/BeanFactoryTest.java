package top.treegrowth.springsource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

/**
 * @author wusi
 * @version 2017/2/18 19:43.
 */
public class BeanFactoryTest {

    @Test
    public void testSimpleLoad() {
        XmlBeanFactory bf = new XmlBeanFactory(new ClassPathResource("test/bean.xml"));
        MyTestBean bean = (MyTestBean) bf.getBean("myTestBean");
        assertEquals("testStr", bean.getTestStr());
    }

    @Test
    public void testClassPathResourceGetInputStream() {
        //ClassPathResource 初始化的时候构造函数会互相调用，其中classLoader 如果为空的话
        //就调用 ClassUtils.getDefaultClassLoader()
        Resource resource = new ClassPathResource("test/bean.xml");
        try {
            InputStream inputStream = resource.getInputStream();
            Assert.assertTrue(inputStream != null);
        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

}
