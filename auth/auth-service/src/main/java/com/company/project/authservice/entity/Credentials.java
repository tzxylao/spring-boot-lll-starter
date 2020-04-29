package com.company.project.authservice.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020/4/29 14:59
 **/
@Data
public class Credentials {
    private Integer id;
    private String name;
    private Boolean enabled;
    private String password;
    private Integer version;
    private List<GrantedAuthority> grantedAuthorities;
}
