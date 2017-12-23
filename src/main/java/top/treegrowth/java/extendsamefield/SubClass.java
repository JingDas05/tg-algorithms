package top.treegrowth.java.extendsamefield;

import org.junit.Test;

/**
 * @author wusi
 * @version 2017/8/21 10:46
 */
public class SubClass extends ParentClass {

    @Test
    public void test() {
        SubClass childClass = new SubClass();
//        ParentClass childClass = new SubClass();
        childClass.appendSql("sub");
        System.out.println(childClass.getSql());
        System.out.println(childClass.a);

        // 如果使用父类指向子类的实例，那么成员变量还是父类的
        childClass.appendSql("parent");
        System.out.println(childClass.getSql());
    }

    public class ChildClass extends ParentClass {
        private StringBuilder sql;
        public int a = 2;

        public ChildClass() {
            super();
            this.sql = new StringBuilder();
        }

        public StringBuilder getSql() {
            return sql;
        }

        public void appendSql(String str) {
            super.appendSql(str);
        }

        @Override
        public int getA() {
            return a;
        }

        @Override
        public void setA(int a) {
            this.a = a;
        }
    }
}
