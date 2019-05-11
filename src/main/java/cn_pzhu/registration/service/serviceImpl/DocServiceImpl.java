package cn_pzhu.registration.service.serviceImpl;

import cn_pzhu.registration.domain.DoctorInfo;
import cn_pzhu.registration.domain.Login;
import cn_pzhu.registration.domain.PatientInfo;
import cn_pzhu.registration.mapper.DocMapper;
import cn_pzhu.registration.mapper.LoginMapper;
import cn_pzhu.registration.mapper.PatientMapper;
import cn_pzhu.registration.mapper.UserInfoMapper;
import cn_pzhu.registration.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: registration
 * @description:
 * @author: LemonQ
 * @create: 2019-04-23 11:18
 **/
@Service
public class DocServiceImpl implements DocService {
    @Autowired
    DocMapper docMapper;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    LoginMapper loginMapper;

    @Autowired
    PatientMapper patientMapper;

    @Override
    public List<DoctorInfo> selectDoc(int dept_id) {
        return docMapper.selectDoc(dept_id);
    }


    @Override
    public Boolean updateRegisterSuccess(String docId, String pId) {
        Boolean b = docMapper.updateRegisterSuccess(docId, pId);
        return b;
    }

    @Override
    public List<PatientInfo> selectListPatient(String docId) {
        List<PatientInfo> patientInfos = docMapper.selectListPatient(docId);
        return patientInfos;

    }

    @Override
    public DoctorInfo selectDocInfo(String docId) {
        DoctorInfo doctorInfo = docMapper.selectDocInfo(docId);
        return doctorInfo;
    }

    @Override
    public Map<String, Object> updateDocInfo(String newId, String password, String id, String intro, String idcard, String name, String sex, String age, int deptId) {
        Map<String, Object> map = new HashMap<>();
        List<PatientInfo> patientInfos1 = userInfoMapper.selectDocIdOfPatient(id);
        int size = patientInfos1.size();
        boolean b = false;
        if (size != 0) {
            b = userInfoMapper.updateDocInfo(newId, password, id, intro, idcard, name, sex, age, deptId);
        } else {
            b = userInfoMapper.updateDocInfo1(newId, password, id, intro, idcard, name, sex, age, deptId);
            System.out.println(b);
        }

        DoctorInfo doctorInfo = docMapper.selectDocInfo(newId);

        List<PatientInfo> patientInfos = docMapper.selectListPatient(newId);

        Login user = loginMapper.getUser(newId);
        map.put("b", b);
        map.put("doctorInfo", doctorInfo);
        map.put("patientInfos", patientInfos);
        map.put("user", user);
        return map;
    }


}
