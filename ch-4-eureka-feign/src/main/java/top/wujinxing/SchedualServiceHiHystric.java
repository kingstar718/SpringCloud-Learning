package top.wujinxing;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author wujinxing
 * date 2019 2019/7/4 19:35
 * description SchedualServiceHiHystric需要实现SchedualServiceHi 接口，并注入到Ioc容器中
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry " + name;
    }
}
