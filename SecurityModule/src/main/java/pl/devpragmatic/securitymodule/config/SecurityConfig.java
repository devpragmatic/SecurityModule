package pl.devpragmatic.securitymodule.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Default config for security
 *
 * @author devpragmatic
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
                .usersByUsernameQuery(
                        "select username, password, enabled from users where username=?")
                .authoritiesByUsernameQuery(    
                        "select u.username, r.name from user_roles ur, users u, roles r where u.username=? and u.user_id = ur.user_id and ur.role_id = r.role_id");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        customConfigure(http);
    }

    /**
     * Override this method to add custom configure to the {@link HttpSecurity}. Typically subclasses
     * should not invoke this method by calling super as it may override their
     * configuration.
     *
     * @param http the {@link HttpSecurity} to modify
     * @throws java.lang.Exception anything Exception
     */
    protected void customConfigure(HttpSecurity http) throws Exception {

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}