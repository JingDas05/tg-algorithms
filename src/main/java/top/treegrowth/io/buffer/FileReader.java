package top.treegrowth.io.buffer;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author wusi
 * @version 2018/11/1.
 */
public class FileReader {

    public static void main(String[] args) throws Exception {

        InputStream file = FileReader.class.getClassLoader().getResourceAsStream("test1.csv");
        BufferedReader reader = new BufferedReader(new InputStreamReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            try {
                System.out.println(Integer.parseInt(line));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
