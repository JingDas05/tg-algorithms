package top.treegrowth.java.aop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wusi
 * @version 2019/1/10 22:19.
 */
@RestController
@RequestMapping("aop")
public class DownloadController {

    @RequestMapping(method = RequestMethod.POST, value = "/download")
    @Timer
    public void downLoad() {
        System.out.println("download");
    }
}
