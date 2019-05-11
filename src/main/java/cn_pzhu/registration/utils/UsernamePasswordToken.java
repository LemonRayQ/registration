package cn_pzhu.registration.utils;

/**
 * @program: registration
 * @description: 自定义shiro用户名，密码，身份验证
 * @author: LemonQ
 * @create: 2019-04-24 20:12
 **/

public class UsernamePasswordToken extends org.apache.shiro.authc.UsernamePasswordToken {
    private static final long serialVersionID = 1L;
    private String identity;

    public UsernamePasswordToken() {
        super();
    }

    public UsernamePasswordToken(String username, String password, String identity) {
        super(username, password);
        this.identity = identity;
    }

  /*  public UsernamePasswordToken(String username, char[] password,
                                 boolean rememberMe, String host, String identity) {
        super(username, password, rememberMe, host);
        this.identity = identity;
    }*/

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}
