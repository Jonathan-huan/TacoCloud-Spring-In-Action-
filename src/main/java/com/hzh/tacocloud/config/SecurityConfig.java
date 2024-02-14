package com.hzh.tacocloud.config;

import com.hzh.tacocloud.domain.entity.User;
import com.hzh.tacocloud.domain.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Mono;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//    @Bean
//    public UserDetailsService userDetailsService(UserRepository userRepository) {
//        return username -> {
//            User user = userRepository.findByUsername(username);
//            if(user!=null)return user;
//            throw new UsernameNotFoundException("User '"+username+"' not found");
//        };
//    }

    @Bean
    @Profile("dev")
    public ReactiveUserDetailsService userDetailsService(UserRepository userRepository){
        return username -> {
            User user = userRepository.findByUsername(username);
            if(user!=null)return Mono.just(user);
            throw new UsernameNotFoundException("User '"+username+"' not found");
        };
    }

    @Bean
    @Profile("dev")
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(
                registry -> registry
                        .requestMatchers("/design","/orders").hasRole("USER")
                        .requestMatchers("/","/**").permitAll())
                        .csrf(configurer -> configurer.ignoringRequestMatchers("/h2-console/**").disable()) //开发环境禁用csrf保护
                        .headers(configurer -> configurer.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                        .formLogin(configurer -> configurer.loginPage("/login")
                ).build();
    }

//    @Bean
//    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) throws Exception {
//        return http.authorizeExchange(
//                spec->spec
//                        .pathMatchers("/api/tacos","orders")
//                        .hasAuthority("USER")
//                        .anyExchange()
//                        .permitAll()
//                ).build();
//    }
}
