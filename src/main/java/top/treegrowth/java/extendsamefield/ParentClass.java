package top.treegrowth.java.extendsamefield;

/**
 * @author wusi
 * @version 2017/8/21 10:48
 */
public class ParentClass {
    private final StringBuilder sqlBuilder = new StringBuilder();

    //获取sql语句，去掉前后空格
    public String getSql() {
        return sqlBuilder.toString().trim();
    }

    public void appendSql(String sql) {
        sqlBuilder.append(sql);
        sqlBuilder.append(" ");
    }
}
