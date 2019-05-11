package cn_pzhu.registration.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @program: registration
 * @description: 病例反馈实体
 * @author: LemonQ
 * @create: 2019-04-24 18:23
 **/
@Entity
public class Illness {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    private String pId;
    private String docId;
    private String content;

    @Override
    public String toString() {
        return "FeedBack{" +
                "id=" + id +
                ", pId='" + pId + '\'' +
                ", docId='" + docId + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
