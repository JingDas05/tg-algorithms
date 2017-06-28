package top.treegrowth.designmodel.factory.cache_factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wusi
 * @version 2017/6/28 9:03
 */
public class Factory {

    private static final Map<String, Product> cacheMap = new HashMap<>();

    public static synchronized Product getInstance(String name) {
        Product product = null;
        if (cacheMap.containsKey(name)) {
            product = cacheMap.get(name);
        } else {
            if (name.equals("product1")) {
                product = new ConcereteProduct1();
            } else if (name.equals("product2")) {
                product = new ConcereteProduct2();
            }
            cacheMap.put(name, product);
        }
        return product;
    }
}
