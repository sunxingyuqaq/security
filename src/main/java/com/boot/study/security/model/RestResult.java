package com.boot.study.security.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xingyu Sun
 * @date 2019/6/27 13:33
 */
@Data
public class RestResult<T> {

    private static final String SUCCESS_MSG = "OK";
    private static final String SUCCESS_CODE = "200200";

    private String msg;

    private String code;

    private T data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long total;

    public static RestResult success(Object data) {
        return new RestResult<>(SUCCESS_MSG, SUCCESS_CODE, data);
    }

    public static RestResult success(Object... data) {
        List<Object> list = new ArrayList<>();
        for (int i = data.length - 1; i >= 0; i--) {
            list.add(data[i]);
        }
        return new RestResult<>(SUCCESS_MSG, SUCCESS_CODE, list);
    }

    public static RestResult success(Object data, long total) {
        return new RestResult<>(SUCCESS_MSG, SUCCESS_CODE, data, total);
    }

    public static RestResult fail(ErrorEnums code) {
        return new RestResult<>(code, "");
    }

    public static RestResult fail(ErrorEnums code,String msg) {
        return new RestResult<>(code.getCode(),msg, "");
    }

    public static RestResult fail(String code, String msg) {
        return new RestResult<>(msg, code, "");
    }

    public RestResult(ErrorEnums code) {
        this.code = code.getCode();
        this.msg = code.getMsg();
    }

    public RestResult(ErrorEnums code, T data) {
        this.code = code.getCode();
        this.msg = code.getMsg();
        this.data = data;
    }

    public RestResult(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }

    public RestResult(String msg, String code, T data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public RestResult(String msg, String code, T data, Long total) {
        this.msg = msg;
        this.code = code;
        this.data = data;
        this.total = total;
    }
}
