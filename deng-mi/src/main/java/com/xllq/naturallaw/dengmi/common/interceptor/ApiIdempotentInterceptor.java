/**
 * Created by xiamen safedog on 2019年06月28日
 */
package com.xllq.naturallaw.dengmi.common.interceptor;

import com.xllq.naturallaw.dengmi.common.annotation.ApiIdempotent;
import com.xllq.naturallaw.dengmi.token.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Auther: huanglq
 * @Date: 2019/6/28 0028
 * @Description: 接口幂等性拦截器
 */
public class ApiIdempotentInterceptor implements HandlerInterceptor {
    private static final String TOKEN_NAME = "token";
    @Autowired
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        ApiIdempotent methodAnnotation = method.getAnnotation(ApiIdempotent.class);
        if (methodAnnotation != null) {
            check(request);// 幂等性校验, 校验通过则放行, 校验失败则抛出异常, 并通过统一异常处理返回友好提示
        }
        return true;
    }

    private void check(HttpServletRequest request) {
        String token = request.getHeader(TOKEN_NAME);
        if (StringUtils.isEmpty(token)) {// header中不存在token
            token = request.getParameter(TOKEN_NAME); // parameter中也不存在token
        }
        tokenService.checkToken(token);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
