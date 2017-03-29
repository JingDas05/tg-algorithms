package top.treegrowth.io;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

/**
 * @author wusi
 * @version 2017/3/22 11:06
 */
public class Xmlparser {

    public Document getDocument(String text) throws DocumentException {
        Document document;
        document = DocumentHelper.parseText(text);
        return document;
    }

    //下面是read大多数的操作
    public void readOperation(String source) throws DocumentException {
        Document document = getDocument(source);
        Element element = document.getRootElement();
        element.getName();
        element.attributeCount();
        element.attributeValue("");
        element.elements();
    }

    public Document createDocument() throws DocumentException {
        Document document;
        document = DocumentHelper.createDocument();
        return document;
    }

    //下面是write大多数的操作
    public void writeOperation() throws DocumentException, IOException {
        Document document = createDocument();
        Element element = document.addElement("elementName");
        element.addAttribute("name", "value");
        //指定输出格式
        OutputFormat format = OutputFormat.createPrettyPrint();//Format格式！！
        format.setEncoding("UTF-8");
        format.setIndent(true);
        /**
         * 新建文件输出对象
         * this.getClass().getResource("/"), 获取类加载的根路径   D:\git\daotie\daotie\target\classes
         * this.getClass().getResource(""), 获取当前类的所在工程路径; 如果不加“/”  获取当前类的加载目录  D:\git\daotie\daotie\target\classes\my
         */
        File file = new File(this.getClass().getResource("/").getPath() + "/");
        if (!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        if (!file.exists()) file.createNewFile();
        //构建输出流 文件或者字符串
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        StringWriter strWtr = new StringWriter();
        //下面的fileOutputStream 可以换成 strWtr
        XMLWriter xmlWriter = new XMLWriter(fileOutputStream, format);
        xmlWriter.write(document);
        xmlWriter.close();
    }
}
