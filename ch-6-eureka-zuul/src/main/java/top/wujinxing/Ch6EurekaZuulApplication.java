package top.wujinxing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableZuulProxy  //注解@EnableZuulProxy，开启zuul的功能
public class Ch6EurekaZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch6EurekaZuulApplication.class, args);
    }

}
