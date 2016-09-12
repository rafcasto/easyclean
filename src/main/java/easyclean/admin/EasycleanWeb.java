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
        registry.addViewController("/employee/add_employee").setViewName("admindashboard/employees_add");;        
        registry.addViewController("/employee/show_employees").setViewName("admindashboard/employees");
        //Portfolio registery
        registry.addViewController("/portfolio/add_portfolio").setViewName("admindashboard/portfolio_add");;        
        registry.addViewController("/portfolio/show_portfolio").setViewName("admindashboard/portfolio");
        //Roster
        registry.addViewController("/roster/save_roster").setViewName("admindashboard/roster");;        
        
    }

	
	
	
	
}
