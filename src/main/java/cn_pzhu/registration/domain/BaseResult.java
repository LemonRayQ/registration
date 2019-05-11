package cn_pzhu.registration.domain;

import java.io.Serializable;

/**
 * @program: registration
 * @description: 基础结果返回集
 * @author: LemonQ
 * @create: 2019-05-06 18:21
 **/

public class BaseResult<T> implements Serializable {

    private static final long serialVersionUID = -6215969907753952597L;
    /**
     * 是否执行成功 ( 默认为true)
     */
    private boolean success = true;

    /**
     * 错误状态码
     */
    private String errCode;

    /**
     * 错误信息
     */
    private String errMsg;
    /**
     * 基础返回信息
     */
    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
