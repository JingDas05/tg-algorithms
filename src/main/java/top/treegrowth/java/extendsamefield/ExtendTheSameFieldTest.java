package top.treegrowth.java.extendsamefield;

import org.junit.Test;

/**
 * @author wusi
 * @version 2017/8/21 10:46
 */
public class ExtendTheSameFieldTest {

    @Test
    public void test() {
        ChildClass childClass = new ChildClass();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(ChildClass.class.getName());
    }

    public class ChildClass extends ParentClass {
        private StringBuilder sqlBuffer;

        public ChildClass() {
            super();
            this.sqlBuffer = new StringBuilder();
        }

        public StringBuilder getSqlBuffer() {
            return sqlBuffer;
        }

        public void setSqlBuffer(StringBuilder sqlBuffer) {
            this.sqlBuffer = sqlBuffer;
        }
    }
}
