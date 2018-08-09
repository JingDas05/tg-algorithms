package top.treegrowth.parallelism.executors.name;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author Administrator
 */
public class TestScheduledExecutorService {
    // 创建线程池
    private static final ScheduledExecutorService delayExportExecutor = Executors.newSingleThreadScheduledExecutor(
            new NamedThreadFactory("DubboServiceDelayExporter", true));

}
