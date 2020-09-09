package com.xsx.demo.service;

import com.xsx.demo.model.base.UserInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author xsx
 * @date 2020/9/8 0008 12:38
 */
@Service
public interface UserService {
    /**
     * 添加
     * @param user
     * @return
     */
    Integer add(UserInfo user);

    /**
     * 通过名字查询
     * @param name
     * @return
     */
    UserInfo findByName(String name);
}
