package cn_pzhu.registration.mapper;

import cn_pzhu.registration.domain.PatientInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @program: registration
 * @description: 病人
 * @author: LemonQ
 * @create: 2019-04-28 16:39
 **/
@Mapper
public interface PatientMapper {
    /**
     * @description:根据id查找病人信息
     * @author: Lemon-grass
     * @date: 2019/4/29
     */
    @Select("select * from patientinfo where id=#{id}")
    PatientInfo selectPatientInfo(@Param("id") String pId);


    /**
     * @description:病人填写信息反馈
     * @author: Lemon-grass
     * @date: 2019/4/30
     */
    @Insert("insert into ${tableName}(p_id,doc_id,content) values(#{patientId},#{docId},#{fdContent})")
    boolean insertFeedBackOrIllness(@Param("tableName") String tableName, @Param("docId") String docId, @Param("patientId") String patientId, @Param("fdContent") String Content);

    /**
     * @description:查询信息反馈内容或查询病人病例情况
     * @author: Lemon-grass
     * @date: 2019/5/5
     */
    @Select("SELECT content FROM ${tableName} WHERE p_id= #{pId}  ORDER BY id DESC LIMIT 1")
    String selectFeedBackOrIllness(@Param("tableName") String tableName, @Param("pId") String pId);


}
