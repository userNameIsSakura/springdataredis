package com.fzw.springdataredis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class SpringdataRedisApplicationTests {


    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("aw","bff");
        System.out.println(redisTemplate.opsForValue().get("aw"));

    }

}
