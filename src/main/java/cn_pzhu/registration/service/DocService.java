package cn_pzhu.registration.service;

import cn_pzhu.registration.domain.DoctorInfo;
import cn_pzhu.registration.domain.PatientInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @program: registration
 * @description:
 * @author: LemonQ
 * @create: 2019-04-23 11:18
 **/

public interface DocService {

    /**
     * @description:根据科室查询对应医生
     * @author: Lemon-grass
     * @date: 2019/4/26
     */
    List<DoctorInfo> selectDoc(@Param("dept_id") int dept_id);

    /**
     * @description:挂号成功，更新病人挂号医生
     * @author: Lemon-grass
     * @date: 2019/4/26
     */
    Boolean updateRegisterSuccess(@Param("docId") String docId, @Param("pId") String pId);

    /**
     * @description:查询医生对应的病人信息
     * @author: Lemon-grass
     * @date: 2019/4/30
     */
    List<PatientInfo> selectListPatient(String docId);

    /**
     * @description:查询医生信息
     * @author: Lemon-grass
     * @date: 2019/5/5
     */
    DoctorInfo selectDocInfo(String docId);

    /**
     * @description:修改或增加医生信息
     * @author: Lemon-grass
     * @date: 2019/5/5
     */
    Map<String, Object> updateDocInfo(String newId, String password, String id,
                                      String intro, String idcard, String name, String sex, String age, int deptId);

}
