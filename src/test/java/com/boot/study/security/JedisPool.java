package com.boot.study.security;

/**
 * @author Xingyu Sun
 * @date 2019/6/29 10:59
 */
public class JedisPool {

    public Jedis getResource(){
        return new Jedis();
    }
}
