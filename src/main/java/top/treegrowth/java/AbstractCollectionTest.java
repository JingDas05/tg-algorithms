package top.treegrowth.java;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author wusi
 * @version 2017/8/13 9:56.
 */
public class AbstractCollectionTest {

    public Collection collection = new AbstractCollection() {
        @Override
        public Iterator iterator() {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }
    };
}
