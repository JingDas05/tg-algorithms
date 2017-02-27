package top.treegrowth.designmodel.strategy;

/**
 * 构建策略的上下文
 *
 * @author wusi
 * @version 2017/2/27 9:27
 */
public class Context {

    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void exec() {
        this.strategy.exec();
    }
}
