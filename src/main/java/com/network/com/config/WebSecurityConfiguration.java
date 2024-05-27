 package com.network.com.config;



import com.network.com.filters.JwtRequestFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
 @CrossOrigin
public class WebSecurityConfiguration{

    private final JwtRequestFilter authFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf-> csrf.disable()).cors(Customizer.withDefaults())
                .authorizeHttpRequests(auth->
                        auth.requestMatchers(HttpMethod.POST,"/admin/**","/customer/**").permitAll().
                                requestMatchers("/authenticate","/signup","/order/**","/**","/admin/**","/customer/**")
                        .permitAll()
                        .requestMatchers("/api/**").authenticated())

                .sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class).
                build();


    }

    @Bean
     public CorsFilter corsFilter() {
         CorsConfiguration corsConfiguration = new CorsConfiguration();
         corsConfiguration.setAllowCredentials(true);
         corsConfiguration.setAllowedOrigins(Arrays.asList("*"));
         corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                 "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
                 "Access-Control-Request-Method", "Access-Control-Request-Headers"));
         corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
                 "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
         corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
         UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
         urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
         return new CorsFilter(urlBasedCorsConfigurationSource);
     }
    @Bean
    public PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration conf) throws Exception{
        return conf.getAuthenticationManager();
    }
}
