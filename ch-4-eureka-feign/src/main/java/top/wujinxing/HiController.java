package top.wujinxing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wujinxing
 * date 2019 2019/7/4 15:51
 * description
 */
@RestController
public class HiController {
    @Autowired
    SchedualServiceHi schedualServiceHi;  //红线。。但可以启动

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name){
        return schedualServiceHi.sayHiFromClientOne(name);
    }
}
