package com.boot.study.security;

import com.boot.study.security.functional.ExectorResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecApplicationTests {

	@Test
	public void contextLoads() {

	}
	private JedisPool pool = new JedisPool();

	private <T> T executeByRedis(ExectorResult<Jedis,T> e){
        Jedis resource = pool.getResource();
        return e.execute(resource);
    }

    @Test
    @Repeat(3)
    public void test(){
        String s1 = this.executeByRedis(s -> s.getClient()+"1111");
        System.out.println(s1);
        Integer integer = this.executeByRedis(s -> 1);
        ArrayList<String> objects = this.executeByRedis(s -> new ArrayList<>());
    }

}
