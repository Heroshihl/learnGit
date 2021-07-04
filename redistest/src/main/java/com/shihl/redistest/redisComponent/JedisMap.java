package com.shihl.redistest.redisComponent;


import org.apache.commons.lang3.SerializationUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**redis中最重要的类，用来实现redis方式的存储模式，用redis来重写Map的存储方式
 * @author shihl
 * @date 2020/10/19 14:00
 * @description
 */
public class JedisMap<K, V extends Serializable> implements Map<K, V> {

    private JedisPool jedisPool;

    private String mainKey;


    /**构造函数注入jedisPool,重写redis配置
     * @param jedisPool redis连接池
     * @param mainKey key
     */
    public JedisMap(JedisPool jedisPool, String mainKey) {
        this.jedisPool = jedisPool;
        this.mainKey = mainKey;
    }

    @Override
    public int size() {
        Jedis jedis = jedisPool.getResource();
        try {
            Long size = jedis.hlen(toBytes(mainKey));
            return size.intValue();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        Jedis jedis = jedisPool.getResource();
        try {
            return jedis.hexists(toBytes(mainKey), toBytes(key.toString()));
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @Override
    public boolean containsValue(Object value) {
        Jedis jedis = jedisPool.getResource();
        try {
            Set<byte[]> keys = jedis.hkeys(toBytes(mainKey));
            for (byte[] key : keys) {
                byte[] byteValue = jedis.hget(toBytes(mainKey), key);
                if(byteValue == null){
                    continue;
                }
                Object value1 = SerializationUtils.deserialize(byteValue);

                if(value.equals(value1)){
                    return true;
                }
            }
            return false;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @Override
    public V get(Object key) {
        Jedis jedis = jedisPool.getResource();
        try {
            byte[] value = jedis.hget(toBytes(mainKey), toBytes(key.toString()));
            if(value == null){
                return null;
            }
            return (V)SerializationUtils.deserialize(value);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @Override
    public V put(K key, V value) {
        Jedis jedis = jedisPool.getResource();
        try {
            byte[] bytesValue = SerializationUtils.serialize(value);
            jedis.hset(toBytes(mainKey), toBytes(key.toString()), bytesValue);
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @Override
    public V remove(Object key) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.hdel(toBytes(mainKey), toBytes(key.toString()));
            return null;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        Jedis jedis = jedisPool.getResource();
        try {
            Set<? extends K> set = m.keySet();
            for (K key : set) {
                V value = m.get(key);
                byte[] bytesValue = SerializationUtils.serialize(value);
                jedis.hset(toBytes(mainKey), toBytes(key.toString()), bytesValue);
            }
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @Override
    public void clear() {
        Jedis jedis = jedisPool.getResource();
        try {
            Set<byte[]> keys = jedis.hkeys(toBytes(mainKey));
            for (byte[] key : keys) {
                jedis.hdel(toBytes(mainKey), key);
            }
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @Override
    public Set<K> keySet() {
        Jedis jedis = jedisPool.getResource();
        try {
            Set<byte[]> keys = jedis.hkeys(toBytes(mainKey));
            Set<K> set = new HashSet<K>();
            for (byte[] key : keys) {
                set.add((K) toString(key));
            }
            return set;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @Override
    public Collection<V> values() {
        Jedis jedis = jedisPool.getResource();
        try {
            Set<byte[]> keys = jedis.hkeys(toBytes(mainKey));
            List<V> list = new ArrayList<V>();
            for (byte[] key : keys) {
                byte[] bytesValue = jedis.hget(toBytes(mainKey), key);
                if(bytesValue == null){
                    continue;
                }
                list.add((V) SerializationUtils.deserialize(bytesValue));
            }
            return list;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Jedis jedis = jedisPool.getResource();
        try {
            Set<byte[]> keys = jedis.hkeys(toBytes(mainKey));
            Set<Entry<K, V>> set = new HashSet<Entry<K, V>>();
            for (byte[] key : keys) {
                byte[] bytesValue = jedis.hget(toBytes(mainKey), key);
                if(bytesValue == null){
                    continue;
                }
                V value = (V) SerializationUtils.deserialize(bytesValue);
                Entry<K, V> entry = new InnerEntry<K, V>((K) toString(key), value);
                set.add(entry);
            }
            return set;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    private static byte[] toBytes(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private static String toString(byte[] bytes) {
        try {
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

}
