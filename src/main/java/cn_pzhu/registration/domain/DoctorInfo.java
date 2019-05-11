package cn_pzhu.registration.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @program: registration
 * @description:
 * @author: LemonQ
 * @create: 2019-04-23 11:08
 **/

public class DoctorInfo implements Serializable {
    private String id;
    private String name;
    private String intro;
    private Integer age;
    private String sex;
    private String idcard;
    private Integer num;
    private Date createTime;
    private Integer deptId;
    private List<PatientInfo> patientInfos;

    @Override
    public String toString() {
        return "DoctorInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", intro='" + intro + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", idcard='" + idcard + '\'' +
                ", num=" + num +
                ", createTime=" + createTime +
                ", deptId=" + deptId +
                ", patientInfos=" + patientInfos +
                '}';
    }

    public List<PatientInfo> getPatientInfos() {
        return patientInfos;
    }

    public void setPatientInfos(List<PatientInfo> patientInfos) {
        this.patientInfos = patientInfos;
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

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
}
