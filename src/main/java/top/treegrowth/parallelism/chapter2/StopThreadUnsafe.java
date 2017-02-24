package top.treegrowth.parallelism.chapter2;

/**
 * @author wusi
 * @version 2017/2/21 20:26.
 */
public class StopThreadUnsafe {

    //看书上代码，不照书敲下来了，还是敲下来吧

    public static User user = new User();

    public static class User {
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "AbstractModel[id=" + id + ",name=" + name + "}";
        }

        public static class ChangeObjectThread extends Thread {

            @Override
            public void run() {
                while (true) {
                    synchronized (user) {
                        int v = (int) System.currentTimeMillis() / 1000;
                        user.setId(v);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        user.setName(String.valueOf(v));
                    }
                    Thread.yield();
                }
            }
        }

        public static class ReadObjectThread extends Thread {

            @Override
            public void run() {
                while (true) {
                    synchronized (user) {
                        if (user.getId() != Integer.parseInt(user.getName())) {
                            System.out.println(user.toString());
                        }
                    }
                    Thread.yield();
                }
            }
        }

        public static void main(String[] args) throws InterruptedException {
            new ReadObjectThread().start();
            while (true) {
                Thread thread = new ChangeObjectThread();
                thread.start();
                Thread.sleep(150);
                thread.stop();
            }
        }
    }
}
