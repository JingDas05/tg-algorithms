package top.treegrowth.source.map;

/**
 * @author wusi
 * @version 2017/8/7 16:43
 */
public class MapTest {

    public static void main(String[] args) {
        MapTest mapTest = new MapTest();
        mapTest.test();
    }

    public void test() {
        Map<String, String> map1 = new HashMap<>();

        map1.put("1", "value");
        map1.get("1");
        System.out.println(map1.containsKey("1"));
        System.out.println(map1.containsValue("value"));
        System.out.println(map1.entrySet());
        System.out.println(map1.keySet());
        System.out.println(map1.values());

        Map<String, String> map2 = new HashMap<>(map1);
        map2.remove("1");
        map2.size();

        map2.clear();
        System.out.println(map2.isEmpty());
        System.out.println(map2.values());
    }
}
