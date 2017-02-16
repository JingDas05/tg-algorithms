package top.treegrowth.algorithms;

import java.io.PrintStream;
import java.util.Date;

public class CustomTests {

    private static final String str1 = "s";
    private static final changebl change = new changebl();

    public static void main(String[] args) {
        change.setStr2("2");
        PrintStream printStream = System.out;
        printStream.print(change);

    }

    static class changebl {

        private String str2;

        public String getStr2() {
            return str2;
        }

        public void setStr2(String str2) {
            this.str2 = str2;
        }

        @Override
        public String toString() {
            return this.getStr2() + "333";
        }
    }
}
