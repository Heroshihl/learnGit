package com.shihl.redistest.redisComponent;

import java.util.Map;

/**JedisMap的辅助构造类
 * @author shihl
 * @date 2020/10/19 14:03
 * @description
 */
public class InnerEntry<K, V> implements Map.Entry<K, V> {
    private K key;
    private V value;

    public InnerEntry(K key, V value) {

        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }


    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        this.value = value;
        return null;
    }

}
