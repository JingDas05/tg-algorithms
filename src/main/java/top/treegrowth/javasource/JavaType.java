package top.treegrowth.javasource;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wusi
 * @version 2017/5/6 21:21.
 */
public enum JavaType {

    ARRAY(Types.ARRAY),VARCHAR(Types.VARCHAR);

    public final int TYPE_CODE;
    public static Map<Integer, JavaType> cokeLookup = new HashMap<>();

    static {
        for (JavaType javaType: JavaType.values()) {
            cokeLookup.put(javaType.TYPE_CODE, javaType);
        }
    }

    JavaType(int code) {
        this.TYPE_CODE = code;
    }

    public JavaType forCode(int code) {
        return cokeLookup.get(code);
    }
}
