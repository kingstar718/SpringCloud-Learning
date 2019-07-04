package top.wujinxing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient  //通过@EnableDiscoveryClient向服务中心注册
public class Ch3EurekaRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch3EurekaRibbonApplication.class, args);
    }

    @Bean
    @LoadBalanced  //@LoadBalanced注解表明这个restRemplate开启负载均衡的功能。
    RestTemplate restTemplate(){
        return new RestTemplate();  //向程序的ioc注入一个bean: restTemplate;
    }

}
