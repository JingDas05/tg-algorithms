package top.treegrowth.serialize;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wusi
 * @version 2018/8/9.
 */
@Component
public class SerializeClient {

    public void test() throws Exception {
        Bean bean1 = new Bean("张三");
        Bean bean2 = new Bean("李四");
        Bean bean3 = new Bean("王五");
        List<Bean> beans = new ArrayList<>();
        beans.add(bean1);
        beans.add(bean2);
//        String valueAsString = ObjectMapperFactory.getObjectMapper().writeValueAsString(new ToBeSerializeBean1(beans, bean3, "测试泛型序列化", 0));
//        System.out.println(valueAsString);
//        ToBeSerializeBean1 toBeSerializeBean1 = ObjectMapperFactory.getObjectMapper().readValue(valueAsString, ToBeSerializeBean1.class);
//        System.out.println("反序列化后的对象");
//        System.out.println(toBeSerializeBean1);

        String valueAsString = ObjectMapperFactory.getObjectMapper().writeValueAsString(new ToBeSerializeBean2<>(beans, bean3, "测试泛型序列化", 0));
        System.out.println(valueAsString);
        ToBeSerializeBean2 toBeSerializeBean2 = ObjectMapperFactory.getObjectMapper().readValue(valueAsString, ToBeSerializeBean2.class);
        System.out.println("反序列化后的对象");
        System.out.println(toBeSerializeBean2);
    }
}
