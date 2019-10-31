package top.treegrowth.commonio;

import com.google.common.collect.Lists;
import org.apache.commons.io.comparator.NameFileComparator;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * 文件名排序工具类
 *
 * @author wusi
 * @version 2017/12/1 13:41
 */
public class NameComparatorTest {

    public static void main(String[] args) {
        List<File> files = Lists.newArrayList(new File("1.txt"), new File("3.txt"), new File("2.txt"));
        ((NameFileComparator) NameFileComparator.NAME_COMPARATOR).sort(files);
        Iterator<File> fileIterator = files.iterator();
        while (fileIterator.hasNext()) {
            System.out.println(fileIterator.next().getName());
        }
    }
}
