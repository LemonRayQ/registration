package cn_pzhu.registration.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import cn_pzhu.registration.realm.UserRealm;
import cn_pzhu.registration.service.LoginService;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: registration
 * @description:
 * @author: LemonQ
 * @create: 2019-04-22 20:35
 **/
@Configuration
public class ShiroConfig {

    @Autowired
    private LoginService loginService;

    /**
     * @description:创建ShiroFilterFactoryBean
     * @author: Lemon-grass
     * @date: 2019/4/22
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityMannager") DefaultWebSecurityManager securityManager, HttpServletRequest request) {
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        filterFactoryBean.setSecurityManager(securityManager);

        //filterFactoryBean.setSuccessUrl("/patient");
        //filterFactoryBean.setUnauthorizedUrl("/unauthorized");
        //修改调整的登陆页面
        filterFactoryBean.setLoginUrl("/login");

        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/Dregister", "anon");
        filterMap.put("/toRegister", "anon");
        filterMap.put("/logout", "logout");
        filterMap.put("/login", "anon");
        filterMap.put("/register", "anon");
        filterMap.put("/Dlogin", "anon");
        filterMap.put("/js/**", "anon");
        filterMap.put("/css/**", "anon");
        filterMap.put("/img/**", "anon");
        filterMap.put("/**", "authc");
        filterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return filterFactoryBean;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityMannager") DefaultWebSecurityManager securityMannager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityMannager);
        return authorizationAttributeSourceAdvisor;
    }


    /**
     * @description:创建DefaultWebSecurityMannager
     * @author: Lemon-grass
     * @date: 2019/4/22
     */
    @Bean(name = "securityMannager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * @description:创建realm
     * @author: Lemon-grass
     * @date: 2019/4/22
     */

    @Bean(name = "userRealm")
    public UserRealm userRealm() {
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }

    /*@Bean(name="hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("MD5");
        matcher.setHashIterations(1024);
        matcher.setStoredCredentialsHexEncoded(true);
        return matcher;
    }*/

    /**
     * 配置ShiroDialect，用于thymeleaf和shiro标签配合使用
     */
    @Bean
    public ShiroDialect shiroDialect() {

        return new ShiroDialect();
    }
}
