package com.xsx.demo;

import com.xsx.demo.dao.UserMapperTk;
import com.xsx.demo.model.base.UserInfo;
import com.xsx.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    UserService userAddService;

    @Resource
    UserMapperTk userMapperTk;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Test
    void contextLoads() {
            UserInfo user = new UserInfo();
            user.setPassword(passwordEncoder.encode("456"));
            user.setUsername("ljj");
            userMapperTk.insertSelective(user);
    }

    @Test
    void add(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("ljj");
        userInfo.setPassword("456");
        userAddService.add(userInfo);
    }

}
