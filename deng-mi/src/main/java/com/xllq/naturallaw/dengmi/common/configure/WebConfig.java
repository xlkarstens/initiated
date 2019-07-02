/**
 * Created by xiamen safedog on 2019年07月01日
 */
package com.xllq.naturallaw.dengmi.common.configure;

import com.xllq.naturallaw.dengmi.common.interceptor.ApiIdempotentInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Auther: huanglq
 * @Date: 2019/7/1 0001
 * @Description:
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
    @Autowired
    private ApiIdempotentInterceptor apiIdempotentInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiIdempotentInterceptor);
        super.addInterceptors(registry);
    }

}
