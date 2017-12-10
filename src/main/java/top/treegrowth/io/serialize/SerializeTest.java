package top.treegrowth.io.serialize;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author wusi
 * @version 2017/12/8 7:02.
 */
public class SerializeTest implements Serializable {
    private static final long serialVersionUID = 2990025428386896543L;
    public int num = 100;

    public static void main(String[] args) throws Exception {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("G:\\java-io-test\\test.dat"));
        objectOutputStream.writeObject(new SerializeTest());
        objectOutputStream.flush();
    }
}
