package cn_pzhu.registration.domain;

import java.io.Serializable;

/**
 * @program: registration
 * @description: 管理员信息
 * @author: LemonQ
 * @create: 2019-04-28 15:09
 **/

public class Adminfo implements Serializable {
    private String id;
    private String name;
    private String idcard;

    @Override
    public String toString() {
        return "Adminfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", idcard='" + idcard + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }
}
