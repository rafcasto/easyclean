package easyclean.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
@EnableWebSecurity
@SpringBootApplication
public class EasycleanApplication{

	 	@Bean
	    public Java8TimeDialect java8TimeDialect() {
	        return new Java8TimeDialect();
	    }
	
	public static void main(String[] args) {
		SpringApplication.run(EasycleanApplication.class, args);
	}
	
	

}
