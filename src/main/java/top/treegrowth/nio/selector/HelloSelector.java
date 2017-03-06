package top.treegrowth.nio.selector;

import java.nio.channels.SelectableChannel;
import java.nio.channels.Selector;
import java.nio.channels.spi.AbstractInterruptibleChannel;

/**
 * @author wusi
 * @version 2017/3/5 8:51.
 */
public class HelloSelector {

    public static void main(String[] args) {
        SelectableChannel selectableChannel;

        AbstractInterruptibleChannel abstractInterruptibleChannel;

        //这里管理着一个被注册的通道集合的信息和他们的就绪状态
        Selector selector;
    }
}
