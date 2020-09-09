package com.xsx.demo.common.security;

import com.xsx.demo.model.base.UserInfo;
import com.xsx.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author xsx
 * @date 2020/9/9 0009 11:16
 */
@Component
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userAddService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //通过s查询到用户信息
        UserInfo user = userAddService.findByName(s);
        if (null == user){
            throw new UsernameNotFoundException("用户不存在");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();

        User userDetails = new User(user.getUsername(), user.getPassword(), authorities);
        return userDetails;
    }
}
