package it.uniroma3.spring.security;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
 
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
    	auth
        .inMemoryAuthentication()
            .withUser("user").password("password").roles("ADMIN");
    }
    
    @Override
  	protected void configure(HttpSecurity http) throws Exception {
  		http.authorizeRequests()
  		.antMatchers("/","/css/**", "/js/**", "/img/**","/vendor/**","/less/**","/mail/**","/signUp","/centri","/attivita/resultsAttivita","/allievo/resultsAllievoUtente","/attivitas","/allievi","/centro/resultsCentro","/index.html")
  		.permitAll().antMatchers("/admin/**").hasRole("ADMIN")
  				.anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().logout()
  				.permitAll();
  		http.exceptionHandling().accessDeniedPage("/403");
  	}
  }