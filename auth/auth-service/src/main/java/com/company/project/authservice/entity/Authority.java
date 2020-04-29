package com.company.project.authservice.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author: laoliangliang
 * @description:
 * @create: 2020/4/29 15:13
 **/
@Data
public class Authority implements GrantedAuthority {
    private Integer id;
    private String authority;
}
