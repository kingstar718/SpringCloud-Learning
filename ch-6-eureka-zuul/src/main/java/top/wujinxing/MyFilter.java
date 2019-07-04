package top.wujinxing;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author wujinxing
 * date 2019 2019/7/4 21:07
 * description  zuul不仅只是路由，并且还能过滤，做一些安全验证。
 */
// 似乎配置没起作用
@Component
public class MyFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public String filterType() {  //filterType：返回一个字符串代表过滤器的类型
        return "filter pre";
    }

    @Override
    public int filterOrder() {  //filterOrder：过滤的顺序
        return 0;
    }

    @Override
    public boolean shouldFilter() { //shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
        return true;
    }

    @Override   //run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s>>>%s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if (accessToken == null){
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        log.info("ok");
        return null;
    }
}
