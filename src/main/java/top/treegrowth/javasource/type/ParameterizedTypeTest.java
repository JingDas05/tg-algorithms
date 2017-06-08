package top.treegrowth.javasource.type;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * @author wusi
 * @version 2017/6/8 17:00
 */
public class ParameterizedTypeTest {

    Map<String, String> map;
    public static void main(String[] args) throws Exception {
        Field f = ParameterizedTypeTest.class.getDeclaredField("map");
        System.out.println(f.getGenericType());                               // java.util.Map<java.lang.String, java.lang.String>
        System.out.println(f.getGenericType() instanceof java.lang.reflect.ParameterizedType);  // true
        java.lang.reflect.ParameterizedType pType = (java.lang.reflect.ParameterizedType) f.getGenericType();
        System.out.println(pType.getRawType());                               // interface java.util.Map
        for (Type type : pType.getActualTypeArguments()) {
            System.out.println(type);                                         // 打印两遍: class java.lang.String
        }
        System.out.println(pType.getOwnerType());                             // null
    }
}
