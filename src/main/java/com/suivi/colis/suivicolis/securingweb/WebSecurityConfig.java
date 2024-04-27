/*
 * **
 *  * @project : SuiviColis
 *  * @created : 24/04/2024, 16:45
 *  * @modified : 24/04/2024, 16:45
 *  * @description : This file is part of the SuiviColis project.
 *  * @license : MIT License
 *  **
 */

package com.suivi.colis.suivicolis.securingweb;

import org.springframework.security.authentication.ProviderManager;
import com.suivi.colis.suivicolis.models.enums.Role;
import com.suivi.colis.suivicolis.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private UserService userService;
    public WebSecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) ->
                requests.requestMatchers("/", "/home/**", "/test/**", "/test/custommer/add").permitAll() // the /test/** paths for testing todo: delete it after testing
                        .requestMatchers("/customer/**").hasRole(Role.CUSTOMER_ROLE)
                        .requestMatchers("/delivery/**").hasRole(Role.DELIVERY_MAN_ROLE)
                        .requestMatchers("/agency/**").hasRole(Role.AGENCY_EMPLOYEE_ROLE)
                        .requestMatchers("/management/**").hasAnyRole(Role.SUPER_ADMIN_RULE, Role.ADMIN_EMPLOYEE_ROLE)
                        .anyRequest().authenticated()).formLogin(Customizer.withDefaults())

                .logout(LogoutConfigurer::permitAll);

        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}

