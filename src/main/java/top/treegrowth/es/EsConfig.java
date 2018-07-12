package top.treegrowth.es;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;

/**
 * es配置类
 *
 * @author wusi
 *
 */

@Configuration
@ConfigurationProperties(prefix = "es.cluster")
public class EsConfig {

    private String name;
    private String host;
    private String port;

//    @Bean
//    public TransportClient transportClient() {
//        Settings settings = Settings.builder()
//                .put("cluster.name", name)
//                .put("client.transport.sniff", true)
//                .build();
//        TransportClient client = new PreBuiltTransportClient(settings);
//        String[] hostNames = host.split(",");
//        InetSocketTransportAddress[] addresses = new InetSocketTransportAddress[hostNames.length];
//        for (int i = 0; i < hostNames.length; i++) {
//            addresses[i] = new InetSocketTransportAddress(new InetSocketAddress(hostNames[i], Integer.parseInt(port)));
//        }
//        client.addTransportAddresses(addresses);
//        return client;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setHost(String host) {
//        this.host = host;
//    }
//
//    public void setPort(String port) {
//        this.port = port;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getHost() {
//        return host;
//    }
//
//    public String getPort() {
//        return port;
//    }
}
