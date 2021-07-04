package com.shihl.redistest;

import com.shihl.redistest.config.JedisPoolService;
import com.shihl.redistest.redisComponent.JedisMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

/**
 * @author 石华磊
 */
@SpringBootApplication
@Slf4j
public class RedistestApplication implements ApplicationRunner {

    private String bigKey = "sdt-manager::configMap";

    private String smallKey = "X1400_ABNORMAL_PROMPT_PERCENTAGE";

    @Autowired
    private JedisPoolService jedisPoolService;

    public static Map<String, String> configMap;

//    @Autowired
//    private RedisTemplate<String, String> redisTemplate;

    public static void main(String[] args) {
        SpringApplication.run(RedistestApplication.class, args);
    }

    public void init() {
        configMap = new JedisMap<>(jedisPoolService.getPool(), bigKey);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        jedisPoolService.init();
        init();
//        HashOperations<String, String, Object> hash = redisTemplate.opsForHash();
//        Map<String, Object> entries = hash.entries(bigKey);
//        log.info("bigKey====={}",entries);
//        Object o = hash.get(bigKey, smallKey);
//        log.info("1400参数配置值为======{}", o);
        configMap.put("name","shihl123");
        configMap.put(smallKey,"49");
        String s = configMap.get(smallKey);
        String name = configMap.get("name");
        log.info("我的名字是：{}",name);
        log.info("1400异常百分比为：{}",s);

    }
}
