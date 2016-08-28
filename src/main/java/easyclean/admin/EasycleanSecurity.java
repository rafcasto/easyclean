package easyclean.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@EnableWebSecurity
@Configuration
public class EasycleanSecurity  extends WebSecurityConfigurerAdapter {

	
	@Override
    protected void configure(HttpSecurity http) throws Exception { 		
        http.csrf().disable().authorizeRequests()
        .antMatchers("/login").permitAll()
        .antMatchers(HttpMethod.POST,"/login").permitAll()
        .antMatchers("/login**").permitAll()                
        .antMatchers("/static/**","/jquery/**","/bootstrap3/**","/js/**","/static/assets/**","/static/assets/css/**","/static/assets/fonts/**","/static/assets/sass/**","/static/assets/js/**","/static/assets/img").permitAll()         
        .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/admin_employee")                
                .permitAll()                
                .and()
            .logout();
    }		
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
}
