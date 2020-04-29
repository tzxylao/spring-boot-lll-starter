package com.company.project.authserivceimpl.service;

import com.company.project.authservice.entity.Authority;
import com.company.project.authservice.entity.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcUserDetails implements UserDetailsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Credentials credentials = jdbcTemplate.queryForObject(String.format("select id,enabled,name,password,version from credentials where name='%s'", username), (resultSet, i) -> {
            Credentials cred = new Credentials();
            cred.setId(resultSet.getInt(1));
            cred.setEnabled(resultSet.getBoolean(2));
            cred.setName(resultSet.getString(3));
            cred.setPassword(resultSet.getString(4));
            cred.setVersion(resultSet.getInt(5));
            return cred;
        });
        if (credentials == null) {
            throw new UsernameNotFoundException("User '" + username + "' can not be found");
        }
        // 权限
        List<Authority> authoritys = jdbcTemplate.query(String.format("select a.authority from authority a " +
                "join credentials_authorities b on a.id=b.authorities_id where a.id=%d", credentials.getId()), (resultSet, i) -> {
            Authority auth = new Authority();
            auth.setAuthority(resultSet.getString("authority"));
            return auth;
        });
        return new User(credentials.getName(), credentials.getPassword(), credentials.getEnabled(), true, true, true, authoritys);
    }

}