package top.treegrowth.java.extendsamefield;

/**
 * @author wusi
 * @version 2017/8/21 10:48
 */
public class ParentClass {
    private final StringBuilder sql = new StringBuilder();
    public int a = 0;

    public StringBuilder getSql() {
        return sql;
    }

    public void appendSql(String str) {
        sql.append(str);
        sql.append(" ");
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
