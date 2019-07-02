package com.xllq.naturallaw.dengmi.common.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheUtilTest {
    @Autowired
    private CacheUtil cacheUtil;

    @Test
    public void hasKey() {
        boolean ssh = cacheUtil.hasKey("ssh");
        System.out.println(ssh);
    }

    @Test
    public void set() {
        boolean b = cacheUtil.set("ssh", "value", 1000);
        System.out.println(b);
    }

    @Test
    public void bDel() {
        long ssh = cacheUtil.del("ssh");
        System.out.println(ssh);
    }
}