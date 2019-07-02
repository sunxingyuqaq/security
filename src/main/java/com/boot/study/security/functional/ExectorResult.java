package com.boot.study.security.functional;

import com.baomidou.mybatisplus.extension.api.R;

/**
 * @author Xingyu Sun
 * @date 2019/6/29 9:54
 */
@FunctionalInterface
public interface ExectorResult<T,R> {

    int SUM = 0;

    /**
     * execute
     * @param t t
     * @return
     */
    R execute(T t);

    default void print(){
        System.out.println("ok");
    }
}
