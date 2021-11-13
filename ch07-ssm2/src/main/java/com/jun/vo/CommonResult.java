package com.jun.vo;

/**
 * @author HuangJun7
 * @date 2021-11-13 17:56
 */
public class CommonResult {
    //表示本次请求是否处理成功0表示成功，1表示失败
    private Integer code;
    //错误原因
    private String msg;
    //数据
    private Object data;

    public CommonResult() {
    }

    public CommonResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
