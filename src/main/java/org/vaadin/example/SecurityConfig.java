package org.vaadin.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.vaadin.flow.spring.security.VaadinWebSecurity;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends VaadinWebSecurity {

	@Bean
	SecurityFilterChain aadFilterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable());
		http.authorizeHttpRequests(
				auth -> auth.requestMatchers("/login", "/logout","/VAADIN/**").permitAll().anyRequest().authenticated())
				.oauth2Login(Customizer.withDefaults());

		return http.build();		
	}

}
