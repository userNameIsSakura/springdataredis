package com.fzw.changeserialization;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class ChangeserializationApplicationTests {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

/*    @Autowired
    private RedisTemplate redisTemplate;*/


    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("aw","bff");
        System.out.println(redisTemplate.opsForValue().get("aw"));

    }

}
