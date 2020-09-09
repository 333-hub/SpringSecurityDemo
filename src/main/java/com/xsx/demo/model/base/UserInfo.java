package com.xsx.demo.model.base;

import com.xsx.demo.tools.SnowFlakeUtil;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * TODO
 *
 * @author xsx
 * @date 2020/9/7 0007 18:45
 */
@Data
@ToString
@Table(name = "user")
public class UserInfo {
    @Id
    private String id = String.valueOf(SnowFlakeUtil.getFlowIdInstance().nextId());
    private String username;
    private String password;
}
