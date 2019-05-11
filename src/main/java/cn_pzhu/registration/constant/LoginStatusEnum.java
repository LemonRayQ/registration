package cn_pzhu.registration.constant;

/**
 * 登录状态码
 */
public enum LoginStatusEnum {

    LOGIN_STATUS_FAILED("-1", "登陆失败"),
    LOGIN_STATUS_VISITOR("0", "游客访问"),
    LOGIN_STATUS_SUCCESS("1", "登录成功"),
    LOGIN_STATUS_TIMEOUT("2", "登录超时");


    private String code;

    private String msg;

    LoginStatusEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
