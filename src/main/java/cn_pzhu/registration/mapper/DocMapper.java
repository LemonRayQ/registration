package cn_pzhu.registration.mapper;

import cn_pzhu.registration.domain.DoctorInfo;
import cn_pzhu.registration.domain.Illness;
import cn_pzhu.registration.domain.PatientInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DocMapper {
    /**
     * @description:根据科室查询对应医生
     * @author: Lemon-grass
     * @date: 2019/4/23
     */
    @Select("select * from doctorinfo where dept_id= #{dept_id}")
    List<DoctorInfo> selectDoc(@Param("dept_id") int dept_id);

    /**
     * @description:挂号成功，更新病人挂号医生
     * @author: Lemon-grass
     * @date: 2019/4/26
     */
    @Update("UPDATE doctorinfo d,patientinfo p SET d.`num`=d.`num`-1, d.`p_id` = #{pId},p.`doc_Id`= #{docId} WHERE d.`id`= #{docId}AND p.`id`=#{pId} AND num >0")
    Boolean updateRegisterSuccess(@Param("docId") String docId, @Param("pId") String pId);

    /**
     * @description:查询医生对应的病人信息
     * @author: Lemon-grass
     * @date: 2019/4/30
     */
    @Select("SELECT * FROM patientinfo WHERE doc_Id = #{docId} ")
    List<PatientInfo> selectListPatient(@Param("docId") String docId);

    /**
     * @description:查询医生信息
     * @author: Lemon-grass
     * @date: 2019/5/5
     */
    @Select("select * from doctorinfo where id=#{docId}")
    DoctorInfo selectDocInfo(@Param("docId") String docId);

    /**
     * @description:查询医生编写的病例情况
     * @author: Lemon-grass
     * @date: 2019/5/6
     */
    @Select("SELECT * FROM illness WHERE p_id= #{pId}  ORDER BY content DESC LIMIT 1")
    Illness selectIllness(@Param("pId") String pId);
}
