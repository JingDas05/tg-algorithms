package top.treegrowth.java.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * @author wusi
 * @version 2019/1/10 22:46.
 */
public class Client {

    public static void main(String[] args) {
        CommonExpress commonExpress = new CommonExpress();
        // 创建代理
        Express expressProxy = (Express) Proxy.newProxyInstance(Client.class.getClassLoader(),
                new Class<?>[]{Express.class},
                new CommonExpressHandler(commonExpress));
        expressProxy.receive("goods");
    }
}
