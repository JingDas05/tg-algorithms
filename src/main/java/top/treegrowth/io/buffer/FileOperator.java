package top.treegrowth.io.buffer;

import java.io.*;

/**
 * @author wusi
 * @version 2018/11/1.
 */
public class FileOperator {

    public static void main(String[] args) throws Exception {
        read();
    }

    public static void read() throws IOException {
//        InputStream file = FileOperator.class.getClassLoader().getResourceAsStream("test1.csv");
//        BufferedReader reader = new BufferedReader(new InputStreamReader(file));
        String filePath = FileOperator.class.getClassLoader().getResource("test1.csv").getFile();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            try {
                System.out.println(Integer.parseInt(line));
                System.out.println(Thread.currentThread().getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 写文件
    public static void write(String[] splitContent) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter("content.txt"));
            for (String each : splitContent) {
                out.write(each);
                out.newLine();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
