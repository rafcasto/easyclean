package easyclean.admin;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class EasycleanWeb extends WebMvcConfigurerAdapter {

	@Override
    public void addViewControllers(ViewControllerRegistry registry) {                     
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/admin_employee").setViewName("admindashboard/employees");
    }

	
	
	
	
}
