package cn_pzhu.registration.service;

import cn_pzhu.registration.domain.Login;

/**
 * @program: registration
 * @description:
 * @author: LemonQ
 * @create: 2019-04-23 10:42
 **/

public interface LoginService {

    /**
     * @description:查询登录用户
     * @author: Lemon-grass
     * @date: 2019/4/24
     */
    Login getUser(String id);

    /**
     * @description:登录跳转页面
     * @author: Lemon-grass
     * @date: 2019/4/25
     */
    String loginUrl(String id, int identity, int verify);


    /**
     * @description:根据不同的身份将数据插入到对应的信息表中,并且将数据插入到login表中
     * @author: Lemon-grass
     * @date: 2019/4/28
     */
    Boolean insertOfIndentity(String id, String name, String password, String sex, int age, int identity);
}
