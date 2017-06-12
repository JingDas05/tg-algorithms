package top.treegrowth.javasource.bridgemethod;

/**
 *
 * 就是说一个子类在继承（或实现）一个父类（或接口）的泛型方法时，在子类中明确指定了泛型类型，那么在编译时编译器会自动生成桥接方法
 *
 * @author wusi
 * @version 2017/6/12 7:19.
 */
public class SubClass implements SuperInterface<String> {

    public static void main(String[] args) {
        SuperInterface superClass = new SubClass();
        System.out.println(superClass.method("abc123"));// 调用的是实际的方法
        // 调用的是桥接方法,程序会报错，在运行时当参数类型不是SubClass声明的类型时，会抛出类型转换异常，
        // 因为这时调用的是桥接方法，而在桥接方法中会进行强制类型转换
        // 抛出异常为 ClassCastException: java.lang.Object cannot be cast to java.lang.String
        System.out.println(superClass.method(new Object()));

        SuperInterface<String> superClass2 = new SubClass();
        System.out.println(superClass2.method("abc123"));// 调用的是实际的方法
//        桥接方法如下
//        public Object method(Object param) {
//            return this.method(((String) param));
//        }
    }

    @Override
    public String method(String param) {
        return null;
    }
}
