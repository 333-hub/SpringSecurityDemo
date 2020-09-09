package com.xsx.demo.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.xsx.demo.dao.UserMapperTk;
import com.xsx.demo.model.base.UserInfo;
import com.xsx.demo.service.UserService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author xsx
 * @date 2020/9/8 0008 12:38
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapperTk userMapperTk;

    @Override
    public Integer add(UserInfo user) {
        user.setUsername("xsx");
        return userMapperTk.insertSelective(user);
    }

    @Override
    public UserInfo findByName(String name) {
        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)){
            criteria.andEqualTo("username",name);
        }

        return userMapperTk.selectOneByExample(example);
    }
}
