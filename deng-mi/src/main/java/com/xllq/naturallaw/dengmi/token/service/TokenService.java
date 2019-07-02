/**
 * Created by xiamen safedog on 2019年06月28日
 */
package com.xllq.naturallaw.dengmi.token.service;

import org.springframework.stereotype.Service;

/**
 * @Auther: huanglq
 * @Date: 2019/6/28 0028
 * @Description:
 */
public interface TokenService {

    /**
     * 跟key生成唯一的token值，放到redis中
     * 如果key为空，就随机生成
     * @param key
     * @return
     */
    public String createToken(String key);

    /**
     * 检查token值，判断是否存在过期等情况，否则就抛出异常，全局捕获该异常
     * @param token
     */
    public void checkToken(String token);
}
