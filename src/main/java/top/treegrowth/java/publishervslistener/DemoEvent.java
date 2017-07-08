package top.treegrowth.java.publishervslistener;

import org.springframework.context.ApplicationEvent;

/**
 * @author wusi
 * @version 2017/3/28 7:35.
 */
public class DemoEvent extends ApplicationEvent{
    private static final long serialVersionUID = -2040538299475098462L;
    private String msg;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
