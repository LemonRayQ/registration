package cn_pzhu.registration.realm;

import cn_pzhu.registration.domain.Login;
import cn_pzhu.registration.service.LoginService;
import cn_pzhu.registration.utils.UsernamePasswordToken;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: registration
 * @description:
 * @author: LemonQ
 * @create: 2019-04-22 20:41
 **/

public class UserRealm extends AuthorizingRealm {
    /**
     * @description:用于授权的方法
     * @author: Lemon-grass
     * @date: 2019/4/22
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {


        return null;
    }

    /**
     * @description:用于认证的方法
     * @author: Lemon-grass
     * @date: 2019/4/22
     */
    @Autowired
    LoginService loginService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //1、把authenticationToken强转为UsernamePasswordToken
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;

        //2、从UsernamePasswordToken中获取前台传输的数据
        String id = upToken.getUsername();

        int identity1 = Integer.parseInt(upToken.getIdentity());

        Login user = loginService.getUser(id);


        if (user == null) {
            throw new UnknownAccountException("用户不存在！");
        } else if (identity1 == user.getIdentity()) {
            Integer identity = user.getIdentity();
            Integer verify = user.getVerify();
            if (identity == 1 && verify == 0) {
                throw new AccountException("管理员未审核");
            }
        } else {
            throw new AccountException("请选择正确角色");
        }
        //6、根据用户的情况，来构建AuthenticationInfo 对象并返回，通常使用的实现类为：SimpleAuthenTticationInfo
        //以下信息是从数据库中获取的
        //1.principal；认证的实体信息，可以是username，也可以是数据表对应的实体类对象

        Object principal = user.getId();
        //2、credentials：密码
        Object credentials = user.getPassword();
        //3、realmName：当前realm对象的name，调用父类的getName（）方法即可
        String realmName = getName();
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, realmName);
        return info;
    }
}
