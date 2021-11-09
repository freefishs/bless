package com.itheima.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import java.util.ResourceBundle;

public class JedisUtil {
    private static String host = null;
    private static int port;
    private static int maxTotal;
    private static int maxIdel;
    private static JedisPool jedisPool = null;
    static {
        ResourceBundle rb = ResourceBundle.getBundle("redis");
        host = rb.getString("redis.host");
        port = Integer.parseInt(rb.getString("redis.port"));
        maxTotal = Integer.parseInt(rb.getString("redis.maxTotal"));
        maxIdel = Integer.parseInt(rb.getString("redis.maxIdel"));
        JedisPoolConfig jpg = new JedisPoolConfig();
        jpg.setMaxTotal(maxTotal);
        jpg.setMaxIdle(maxIdel);
        jedisPool = new JedisPool(jpg,host,port);
    }

    /**
     * 这个换行就是我所搞的测试
     * @return
     */


    public static Jedis getJedis(){
        return jedisPool.getResource();
    }

    /**
     * 这是main方法
     * @param args
     */
    public static void main(String[] args) {
        JedisUtil.getJedis();
    }
}
