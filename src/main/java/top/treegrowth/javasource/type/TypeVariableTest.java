package top.treegrowth.javasource.type;

import org.springframework.util.Assert;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 *
 * 变量泛型
 *
 * @author wusi
 * @version 2017/6/8 17:16
 */
public class TypeVariableTest<K extends Comparable & Serializable, V> {
    K key;
    V value;
    public static void main(String[] args) throws Exception {
        // 获取字段的类型
        Field fk = TypeVariableTest.class.getDeclaredField("key");
        Field fv = TypeVariableTest.class.getDeclaredField("value");
        Assert.isTrue(fk.getGenericType() instanceof TypeVariableTest, "必须为TypeVariable类型");
        Assert.isTrue(fv.getGenericType() instanceof TypeVariableTest, "必须为TypeVariable类型");
        TypeVariable keyType = (TypeVariable)fk.getGenericType();
        TypeVariable valueType = (TypeVariable)fv.getGenericType();
        // getName 方法
        System.out.println(keyType.getName());                 // K
        System.out.println(valueType.getName());               // V
        // getGenericDeclaration 方法
        System.out.println(keyType.getGenericDeclaration());   // class com.test.TypeVariableTest
        System.out.println(valueType.getGenericDeclaration()); // class com.test.TypeVariableTest
        // getBounds 方法
        System.out.println("K 的上界:");                        // 有两个
        for (Type type : keyType.getBounds()) {                // interface java.lang.Comparable
            System.out.println(type);                          // interface java.io.Serializable
        }
        System.out.println("V 的上界:");                        // 没明确声明上界的, 默认上界是 Object
        for (Type type : valueType.getBounds()) {              // class java.lang.Object
            System.out.println(type);
        }
    }
}