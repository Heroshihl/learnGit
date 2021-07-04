package com.shihl.redistest.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


/**配置redis；建立连接池对象
 * @author shihl
 * @date 2020/10/19 13:46
 * @description redis缓存服务
 */
@Component
public class JedisPoolService {
    @Setter
    @Getter
    @Value("${spring.redis.jedis.pool.max-active}")
    private int maxTotal;

    @Setter
    @Getter
    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;

    @Setter
    @Getter
    @Value("${spring.redis.host}")
    private String host;

    @Setter
    @Getter
    @Value("${spring.redis.port}")
    private int port;

    @Setter
    @Getter
    @Value("${spring.redis.password}")
    private String password;

    @Setter
    @Getter
    @Value("${redis.testOnBorrow}")
    private boolean testOnBorrow;

    @Setter
    @Getter
    @Value("${spring.redis.jedis.pool.max-wait}")
    private int maxWait;

    /**
     * 1、定义一个连接池对象
     */
    @Setter
    @Getter
    private JedisPool pool;

    public JedisPoolService() {
    }

    public void init() {
        // 初始化
        // 1、设置连接池的配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置池中最大的连接数量（可选）
        config.setMaxTotal(maxTotal);
        // 设置空闲时池中保有的最大连接数（可选）
        config.setMaxIdle(maxIdle);
        //是否在从池中取出连接前进行检验,如果检验失败,则从池中去除连接并尝试取出另一个
        config.setTestOnBorrow(testOnBorrow);
        //连接池最大阻塞等待时间（使用负值表示没有限制）
        config.setMaxWaitMillis(maxWait);
        // 2、设置连接池对象
        pool = new JedisPool(config, host, port, 10000, password, 0);
    }

    public static void release(JedisPool jedispool, Jedis jedis) {
        if (null != jedis) {
            jedis.close();
        }
    }
}
