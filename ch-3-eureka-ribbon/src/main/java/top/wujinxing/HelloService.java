package top.wujinxing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author wujinxing
 * date 2019 2019/7/4 11:19
 * description
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 由于开启了负载均衡， 会访问不同的客户端实例
     * @param name
     * @return
     */
    public String hiService(String name){
        return restTemplate.getForObject("http://CH-2-EUREKA-CLIENT/hi?name="+name,String.class);
    }
}
