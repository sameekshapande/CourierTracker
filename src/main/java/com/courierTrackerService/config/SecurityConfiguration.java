package com.courierTrackerService.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	 
	private static final String ADMIN = "ADMIN";
	
	
	 @Bean
	    public InMemoryUserDetailsManager userDetailsService() {
	        UserDetails user = User.withDefaultPasswordEncoder()
	                .username("user")
	                .password("password")
	                .roles("USER")
	                .build();
	        UserDetails admin = User.withDefaultPasswordEncoder()
	                .username("admin")
	                .password("password")
	                .roles("ADMIN")
	                .build();
	        return new InMemoryUserDetailsManager(user, admin);
	    }

	    @Bean
	    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
	        return http
	                .csrf(csrf -> csrf.disable())
	                .authorizeRequests(auth -> {
	                    auth.antMatchers("/home").permitAll();
	                    auth.antMatchers("/courierPackageCharge").hasRole("USER");
	                    auth.antMatchers("/admin").hasRole("ADMIN");
	                })
	                .httpBasic(Customizer.withDefaults())
	                .build();
	    }
	/*
	 * @Bean protected InMemoryUserDetailsManager configAuthentication() {
	 * 
	 * UserDetails admin =
	 * User.withDefaultPasswordEncoder().username("admin").password("admin")
	 * .roles(ADMIN).build();
	 * 
	 * UserDetails user =
	 * User.withDefaultPasswordEncoder().username("user").password("user")
	 * .roles("USER").build();
	 * 
	 * return new InMemoryUserDetailsManager(admin,user); }
	 * 
	 * 
	 * @Bean protected SecurityFilterChain filterChain(HttpSecurity http) throws
	 * Exception {
	 * 
	 * //declares which Page(URL) will have What access type
	 * http.httpBasic().and().authorizeHttpRequests()
	 * .antMatchers("/home").permitAll() .antMatchers("/admin").hasRole("ADMIN")
	 * .antMatchers("/courierPackageCharge").hasRole("ADMIN") // Any other URLs
	 * which are not configured in above antMatchers // generally declared
	 * aunthenticated() in real time .anyRequest().authenticated()
	 * 
	 * // Login Form Details .and() .formLogin()
	 * 
	 * // Logout Form Details .and() .logout() .logoutRequestMatcher(new
	 * AntPathRequestMatcher("/logout"))
	 * 
	 * // Exception Details .and() .exceptionHandling()
	 * .accessDeniedPage("/accessDenied") ; return http.build(); }
	 */


	/*
	 * @Bean AuthenticationManager authenticationManager(AuthenticationConfiguration
	 * authenticationConfiguration) throws Exception { return
	 * authenticationConfiguration.getAuthenticationManager(); }
	 */
 

}