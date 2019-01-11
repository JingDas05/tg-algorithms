package top.treegrowth.java.aop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wusi
 * @version 2019/1/10 22:19.
 */
@RestController
@RequestMapping("aop")
public class DownloadController {

    @Resource
    private TimerService timerService;

    @RequestMapping(method = RequestMethod.POST, value = "/download")
    public void downLoad() {
        System.out.println("aop代理的hashcode" + timerService.hashCode());
        timerService.helloWithoutAop();
    }
}
