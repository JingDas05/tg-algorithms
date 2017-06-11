package top.treegrowth.ognl;

import ognl.Ognl;
import ognl.OgnlException;

/**
 * @author wusi
 * @version 2017/6/7 6:48.
 */
public class RootAccess {

    public static void main(String[] args) {
        testOgnl();
    }

    public static void testOgnl()
    {
        User user = new User("rcx", "123");
        Address address = new Address("110003", "沈阳市和平区");
        user.setAddress(address);
        try
        {
            System.out.println(Ognl.getValue("name", user));
            System.out.println(Ognl.getValue("address", user));
            System.out.println(Ognl.getValue("address.port", user));

            //输出结果：
            //rcx
            //com.rcx.ognl.Address@dda25b
            //110003
        }
        catch (OgnlException e)
        {
            e.printStackTrace();
        }
    }

    public static class User {
        private String name;
        private String description;
        private Address address;

        public User(){}

        public User(String name, String description) {
            this.name = name;
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }
    }

    public static class Address {
        private String name;
        private String port ;

        public Address(){}

        public Address(String port, String name) {
            this.name = name;
            this.port  = port ;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPort() {
            return port;
        }

        public void setPort(String port) {
            this.port = port;
        }
    }
}
