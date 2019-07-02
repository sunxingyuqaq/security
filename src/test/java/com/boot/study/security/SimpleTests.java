package com.boot.study.security;

import org.junit.Test;
import org.springframework.test.annotation.Repeat;

/**
 * @author Xingyu Sun
 * @date 2019/6/29 11:07
 */
public class SimpleTests {

    @Test
    @Repeat(3)
    public void test(){
        System.out.println("1");
    }
}
