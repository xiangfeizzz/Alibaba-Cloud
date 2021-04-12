package alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 使用说明：
 *
 * @author huangxiangxiang
 * @version 2.0.0
 * @createTime 2019年09月10日 14:27:00
 */

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApp {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApp.class, args);
    }
}
