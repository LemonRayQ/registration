package cn_pzhu.registration.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: registration
 * @description: 病人实体
 * @author: LemonQ
 * @create: 2019-04-24 18:26
 **/

public class PatientInfo implements Serializable {
    private String id;
    private String name;
    private Integer age;
    private String sex;
    private String idcard;
    private Date createTime;
    private String docId;

    @Override
    public String toString() {
        return "PatientInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", idcard='" + idcard + '\'' +
                ", createTime=" + createTime +
                ", docId='" + docId + '\'' +
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }
}
