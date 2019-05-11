package cn_pzhu.registration.service;

import cn_pzhu.registration.domain.PatientInfo;

import java.util.Map;

/**
 * @program: registration
 * @description: '
 * @author: LemonQ
 * @create: 2019-04-28 16:43
 **/

public interface PatientService {
    /**
     * @description:根据id查找单个病人
     * @author: Lemon-grass
     * @date: 2019/4/28
     */
    PatientInfo selectPatientInfo(String pId);

    /**
     * @description:修改和增加病人个人信
     * @author: Lemon-grass
     * @date: 2019/4/30
     */
    Map<String, Object> updateUserInfo(String newId, String password, String id, String idcard, String name);

    /**
     * @description:病人填写信息反馈
     * @author: Lemon-grass
     * @date: 2019/4/30
     */
    String insertFeedBackOrIllness(String tableName, String docId, String patientId, String Content);


}
