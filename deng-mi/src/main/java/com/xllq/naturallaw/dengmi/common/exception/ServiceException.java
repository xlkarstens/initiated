/**
 * Created by xiamen safedog on 2019年06月28日
 */
package com.xllq.naturallaw.dengmi.common.exception;

/**
 * @Auther: huanglq
 * @Date: 2019/6/28 0028
 * @Description: 业务逻辑异常
 */
public class ServiceException extends RuntimeException{
    private Integer code;
    private String msg;

    public ServiceException() {
    }

    public ServiceException(String msg) {
        this.msg = msg;
    }

    public ServiceException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
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
}
