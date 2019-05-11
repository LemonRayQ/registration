package cn_pzhu.registration.domain;

import java.io.Serializable;

/**
 * @program: registration
 * @description: Department entity
 * @author: LemonQ
 * @create: 2019-04-22 21:48
 **/
public class Department implements Serializable {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
