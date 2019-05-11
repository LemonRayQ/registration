package cn_pzhu.registration.service.serviceImpl;

import cn_pzhu.registration.domain.Login;
import cn_pzhu.registration.domain.PatientInfo;
import cn_pzhu.registration.mapper.DocMapper;
import cn_pzhu.registration.mapper.LoginMapper;
import cn_pzhu.registration.mapper.PatientMapper;
import cn_pzhu.registration.mapper.UserInfoMapper;
import cn_pzhu.registration.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: registration
 * @description:
 * @author: LemonQ
 * @create: 2019-04-28 16:44
 **/
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientMapper patientMapper;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    DocMapper docMapper;

    @Autowired
    LoginMapper loginMapper;

    /**
     * @description:查询病人信息
     * @author: Lemon-grass
     * @date: 2019/5/8
     */
    @Override
    public PatientInfo selectPatientInfo(String pId) {
        PatientInfo patientInfo = patientMapper.selectPatientInfo(pId);
        return patientInfo;
    }

    /**
     * @description:更新用户信息
     * @author: Lemon-grass
     * @date: 2019/5/8
     */
    @Override
    public Map<String, Object> updateUserInfo(String newId, String password, String id, String idcard, String name) {
        HashMap<String, Object> map = new HashMap<>();

        boolean b = userInfoMapper.updateUserInfo(newId, password, id, idcard, name);

        PatientInfo patientInfo = patientMapper.selectPatientInfo(newId);

        Login user = loginMapper.getUser(newId);

        map.put("patientInfo", patientInfo);
        map.put("user", user);
        return map;
    }

    /**
     * @description: 病人插入信息反馈信息并查询对应的信息反馈为前端数据回显做准备
     * @author: Lemon-grass
     * @date: 2019/5/8
     */
    @Override
    public String insertFeedBackOrIllness(String tableName, String docId, String patientId, String Content) {
        if ("".equals(docId) && "".equals(Content)) {
            String content = patientMapper.selectFeedBackOrIllness(tableName, patientId);
            return content;
        }
        boolean b = patientMapper.insertFeedBackOrIllness(tableName, docId, patientId, Content);

        return null;
    }


}
