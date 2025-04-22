package com.telussuko_spring_jwt.demo.spring_security_jwt.config;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired UserDetailsService userDetailsService;



    //step3 used to connect with data base for dynamic
    @Bean
    public AuthenticationProvider authProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        //we need userdetail service just put  . after provider you will see that

        provider.setUserDetailsService(userDetailsService);

        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));//when we are loging with password it check by eccripting

        //used when we are not using Bcriptpassword encoder
        //provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

        return provider;



    }



    //Step 1
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf(csrf->csrf.disable())
                .authorizeHttpRequests(auth -> auth
                // allow anyone to call /register (and /login if you have one)
                .requestMatchers("auth/api/register").permitAll()
                // now lock down everything else
                .anyRequest().authenticated()
        )

//                .formLogin(withDefaults())
                .httpBasic(withDefaults())
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                 .logout(logout -> logout
                .logoutUrl("/logout")
                // on stateless apps this really only clears SecurityContext
                .logoutSuccessHandler((request, response, authentication) -> {
                             response.setStatus(HttpServletResponse.SC_OK);
                             response.getWriter().flush();
                         })
                         .deleteCookies("JSESSIONID")
                         .permitAll()
        );


       return http.build();


    }
    @Bean

    public PasswordEncoder passwordEncoder(){
       return new BCryptPasswordEncoder(12);

    }




}

