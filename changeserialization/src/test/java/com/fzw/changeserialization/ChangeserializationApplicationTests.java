package com.fzw.changeserialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fzw.changeserialization.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class ChangeserializationApplicationTests {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    /*
    * 使用配置类的方法改变序列化方式
    * */
    @Test
    void contextLoads() {
        User lisi = new User("1001", "lisi", 19);
        redisTemplate.opsForValue().set("user1",lisi) ; // 对象转JSON存入redis
        User user = (User) redisTemplate.opsForValue().get("user1"); // JSON反序列化成对象
        System.out.println(user);

    }

    /*
    *
    * 使用StringRedisTemplate
    * 手动实现序列化和反序列化
    * 节省存入类字节码。节省空间
    *
    * */
    @Test
    void stringRedisTemplateTest() throws JsonProcessingException {
        User user = new User("1002", "wangwu", 29);
//        序列化工具
        ObjectMapper objectMapper = new ObjectMapper();

        String s = objectMapper.writeValueAsString(user);

        stringRedisTemplate.opsForValue().set("user2",s);

        String user2 = stringRedisTemplate.opsForValue().get("user2");

        User user1 = objectMapper.readValue(user2, User.class);

        System.out.println(user1);

    }



}
