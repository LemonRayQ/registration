package cn_pzhu.registration.service.serviceImpl;

import cn_pzhu.registration.domain.Login;
import cn_pzhu.registration.mapper.LoginMapper;
import cn_pzhu.registration.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: registration
 * @description:
 * @author: LemonQ
 * @create: 2019-04-23 10:43
 **/
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginMapper loginMapper;


    @Override
    public Login getUser(String id) {
        return loginMapper.getUser(id);
    }

    @Override
    public String loginUrl(String id, int identity, int verify) {
        if (identity == 0) {
            return "patient";
        } else if (identity == 1 && verify == 1) {
            return "doctor";
        } else if (identity == 2) {
            return "admin";
        } else {
            return "login";
        }
    }


    @Override
    public Boolean insertOfIndentity(String id, String name, String password, String sex, int age, int identity) {
        boolean b = loginMapper.register(id, password, identity);
        Login user = loginMapper.getUser(id);

        if (identity == 0) {
            boolean b1 = loginMapper.insertOfIndentity("patientinfo", id, name, sex, age);
            return b1;
        } else {
            return b;
        }
    }


}
