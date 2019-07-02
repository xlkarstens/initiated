/**
 * Created by xiamen safedog on 2019年06月28日
 */
package com.xllq.naturallaw.dengmi.token.service.impl;

import com.xllq.naturallaw.dengmi.common.constant.ResponseCode;
import com.xllq.naturallaw.dengmi.common.exception.ServiceException;
import com.xllq.naturallaw.dengmi.common.util.CacheUtil;
import com.xllq.naturallaw.dengmi.token.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @Auther: huanglq
 * @Date: 2019/6/28 0028
 * @Description: token 的实现类
 */
@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    private CacheUtil cacheUtil;
    /**
     * 跟key生成唯一的token值，放到redis中
     * 如果key为空，就随机生成
     *
     * @param key
     * @return
     */
    @Override
    public String createToken(String key) {
        return null;
    }

    /**
     * 检查token值，判断是否存在过期等情况，否则就抛出异常，全局捕获该异常
     *
     * @param token
     */
    @Override
    public void checkToken(String token) {
        if (StringUtils.isEmpty(token)) {
            throw new ServiceException(ResponseCode.ILLEGAL_ARGUMENT.getMsg());
        }
        if (!cacheUtil.hasKey(token)) {
            throw new ServiceException(ResponseCode.REPETITIVE_OPERATION.getMsg());
        }
        Long del = cacheUtil.del(token);
        if (del <= 0) {
            throw new ServiceException(ResponseCode.REPETITIVE_OPERATION.getMsg());
        }
    }
}
