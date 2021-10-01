package com.example.CRMTorris.config;

import com.example.CRMTorris.config.filter.CheckAuthCookieFilter;
import com.example.CRMTorris.database.service.WorkerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.HeaderWriterLogoutHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String LOGIN_FORM_URL = "/login";
    private static final String LOGIN_PROC_URL = "/auth";
    private static final String LOGOUT_FORM_URL = "/logout";

    private final WorkerService workerService;

    public WebSecurityConfig(WorkerService workerService) {
        this.workerService = workerService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable()
                .addFilterBefore(new CheckAuthCookieFilter(), BasicAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/create/**").hasRole("ADMIN")
                .antMatchers("/static/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .formLogin()
                .loginPage(LOGIN_FORM_URL)
                .loginProcessingUrl(LOGIN_PROC_URL)
                .defaultSuccessUrl("/", true)
                .failureUrl(LOGIN_FORM_URL)
                .and()
                .logout()
                .logoutUrl(LOGOUT_FORM_URL)
                .logoutSuccessUrl(LOGIN_FORM_URL)
                .deleteCookies("auth")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .addLogoutHandler(new HeaderWriterLogoutHandler(new ClearSiteDataHeaderWriter(ClearSiteDataHeaderWriter.Directive.ALL)))
                .permitAll()
                .and()
                .rememberMe()
                .alwaysRemember(true)
                .key("somesecret")
                .and()
                .sessionManagement()
                .enableSessionUrlRewriting(false)
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .invalidSessionUrl(LOGIN_FORM_URL)
                .maximumSessions(3).maxSessionsPreventsLogin(false);
    }

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOriginPattern("*");
        config.addAllowedHeader("Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
        config.addAllowedMethod(HttpMethod.OPTIONS);
        config.addAllowedMethod(HttpMethod.HEAD);
        config.addAllowedMethod(HttpMethod.POST);
        config.addAllowedMethod(HttpMethod.GET);
        config.addAllowedMethod(HttpMethod.PUT);
        config.addAllowedMethod(HttpMethod.DELETE);
        config.setAllowCredentials(true);
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService() {
        return workerService;
    }

    public enum Role {
        WORKER,
        ADMIN,
        ROLE_ANONYMOUS
    }
}
