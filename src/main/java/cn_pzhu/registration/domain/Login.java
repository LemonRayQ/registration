package cn_pzhu.registration.domain;

import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: registration
 * @description:
 * @author: LemonQ
 * @create: 2019-04-22 21:34
 **/
@Repository
public class Login implements Serializable {
    private String id;
    private String password;
    private Integer identity;
    private Integer verify;
    private Date updateTime;

    @Override
    public String toString() {
        return "Login{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", identity=" + identity +
                ", verify=" + verify +
                ", updateTime=" + updateTime +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public Integer getVerify() {
        return verify;
    }

    public void setVerify(Integer verify) {
        this.verify = verify;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
