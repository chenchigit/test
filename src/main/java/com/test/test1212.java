package com.test;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/**
 * Created by wb-chenchi on 2017/12/12.
 */
public class test1212 {


    public  static void main(String[] args){
        Jedis jedis;

//连接redis服务器，192.168.0.100:6379
        jedis = new Jedis("127.0.0.1", 6379);


        jedis.set("name","xinxin");//向key-->name中放入了value-->xinxin
        System.out.println(jedis.get("name"));//执行结果：xinxin
        //测试增加代码

    }


}
