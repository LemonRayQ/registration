package cn_pzhu.registration.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @program: registration
 * @description: 信息反馈实体
 * @author: LemonQ
 * @create: 2019-04-24 18:21
 **/
@Entity
public class FeedBack implements Serializable {
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
