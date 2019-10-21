//package com.example.stduentinfo.demo.config;
//
//import com.example.stduentinfo.demo.shiro.UserRealm;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
///**
// * @Author: Edward Gavin
// * @Create: 2019-10-18 18:42
// */
//@Configuration
//public class ShiroConfig {
//
//    /**
//     * 创建ShiroFilterFactoryBean
//     */
//    @Bean
//    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager){
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//
//        //设置安全管理器
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//
//        Map<String, String> filterMap = new LinkedHashMap<String, String>();
//        filterMap.put("/main.html", "authc");
//
//        shiroFilterFactoryBean.setLoginUrl("/");
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
//
//
//        return shiroFilterFactoryBean;
//    }
//
//    /**
//     * 创建DefaultWebSecurityManager
//     */
//    @Bean(name="securityManager")
//    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        //关联realm
//        securityManager.setRealm(userRealm);
//        return securityManager;
//    }
//
//    /**
//     * 创建Realm
//     */
//    @Bean(name="userRealm")
//    public UserRealm getRealm(){
//        return new UserRealm();
//    }
//}
