package top.treegrowth.baidu;

import com.baidu.aip.speech.AipSpeech;
import org.json.JSONObject;

/**
 *
 * 百度语音识别，语音转文字
 *
 * @author wusi
 * @version 2018/12/9 20:08.
 */
public class SoundTest {

    //设置APPID/AK/SK
    public static final String APP_ID = "你的 App ID";
    public static final String API_KEY = "你的 Api Key";
    public static final String SECRET_KEY = "你的 Secret Key";

    public static void main(String[] args) {
        // 初始化一个AipSpeech
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        // 设置http代理
        //client.setHttpProxy("proxy_host", proxy_port);
        // 设置socket代理
        //client.setSocketProxy("proxy_host", proxy_port);

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        JSONObject res = client.asr("test.pcm", "pcm", 16000, null);
        System.out.println(res.toString(2));

    }
}
