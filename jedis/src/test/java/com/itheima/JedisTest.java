package com.itheima;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisTest {

    @Test
    public void testjedis(){
        //连接jedis
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //操作jedis
        jedis.set("name","itheima");
        //关闭jedis
        jedis.close();
    }
    //测试list
    @Test
    public void testlist(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.del("list1");
        jedis.lpush("list1","a","b","c");
        jedis.rpush("list1","d","d","f");
        List<String> list1 = jedis.lrange("list1", 0, -1);
        for(String s : list1){
            System.out.print(s+" ");
        }
        System.out.println(jedis.llen("list1"));
    }


    @Test
    public void testhash(){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.del("hash1");
        jedis.hset("hash1","a1","a1");
        jedis.hset("hash1","a2","a2");
        jedis.hset("hash1","a3","a3");
        Map<String, String> hash1 = jedis.hgetAll("hash1");
        System.out.println(hash1);
//        map的第一种遍历方式
        for (String s : hash1.keySet()){
            String s1 = hash1.get(s);
            System.out.println(s+"  "+s1);
        }
        System.out.println(jedis.hlen("hash1"));


    }

    @Test
    public void testset(){

    }

    @Test
    public void testsortedset(){

    }
}
