package top.wujinxing;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author wujinxing
 * date 2019 2019/7/4 17:24
 * description
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")  //该注解对该方法创建了熔断器的功能，并指定了fallbackMethod熔断方法
    public String hiService(String name){
        return restTemplate.getForObject("http://CH-2-EUREKA-CLIENT/hi?name="+name, String.class);
    }

    //熔断方法直接返回了一个字符串
    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
