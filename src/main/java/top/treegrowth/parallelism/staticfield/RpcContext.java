package top.treegrowth.parallelism.staticfield;

import java.net.InetSocketAddress;

/**
 * @author Administrator
 */
public class RpcContext {


    // 这个地方尽管用final static修饰，但是 threadLocal是和线程绑定的，如果有100个线程，就有100个threadLocal
    private static final ThreadLocal<RpcContext> LOCAL = new ThreadLocal<RpcContext>() {
        @Override
        protected RpcContext initialValue() {
            return new RpcContext();
        }
    };

    /**
     * get context.
     *
     * @return context
     */
    public static RpcContext getContext() {
        return LOCAL.get();
    }


    private String remoteAddress;

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }
}
