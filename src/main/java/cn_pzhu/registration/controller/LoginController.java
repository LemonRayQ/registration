package cn_pzhu.registration.controller;

import cn_pzhu.registration.domain.Login;
import cn_pzhu.registration.service.LoginService;
import cn_pzhu.registration.utils.UsernamePasswordToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: registration
 * @description:
 * @author: LemonQ
 * @create: 2019-04-22 20:52
 **/
@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "/Dlogin")
    public String login(Login login, HttpServletRequest request) {
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        String id = login.getId();
        String password = login.getPassword();
        String identity = request.getParameter("identity");
        if (!subject.isAuthenticated()) {

            UsernamePasswordToken token = new UsernamePasswordToken(id, password, identity);
            //  token.setRememberMe(true);
            try {
                subject.login(token);

                request.getSession().setAttribute("userId", id);

                Login user = loginService.getUser(id);
                Integer verify = user.getVerify();
                request.getSession().setAttribute("userPwd", user);

                return "redirect:/" + loginService.loginUrl(id, login.getIdentity(), verify);
            } catch (AuthenticationException ae) {
                request.getSession().setAttribute("msg", "登录失败");
                return "redirect:/login";
            }
        }

        Login user = loginService.getUser(id);
        return "redirect:/" + loginService.loginUrl(id, login.getIdentity(), user.getVerify());
    }

    /**
     * @description:跳转注册页面
     * @author: Lemon-grass
     * @date: 2019/4/27
     */
    @RequestMapping("/toRegister")
    @ResponseBody
    public int toRegister(Login login, HttpServletRequest request) {
        int identity = login.getIdentity();

        request.getSession().setAttribute("registerIdentity", identity);

        return identity;
    }

    @RequestMapping("/register")
    public String register(HttpServletRequest request) {
        return "register";
    }

    /**
     * @description: 注册操作
     * @author: Lemon-grass
     * @date: 2019/4/27
     */
    @RequestMapping("/Dregister")
    public String Dregister(Login login, HttpServletRequest request) {
        int identity = (int) request.getSession().getAttribute("registerIdentity");

        String id = login.getId();
        String password = login.getPassword();
        String name = null;
        String sex = null;
        int age = 0;
        boolean b = false;
        if (identity == 0) {
            name = request.getParameter("username");
            sex = request.getParameter("sex");
            age = Integer.parseInt((String) request.getParameter("age"));
        }

        if (identity == 1) {
            b = loginService.insertOfIndentity(id, name, password, sex, age, identity);
        }
        if (b) {
            return "login";
        } else {
            return "register";
        }
    }

}
