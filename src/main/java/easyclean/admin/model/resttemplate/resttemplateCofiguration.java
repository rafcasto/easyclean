package easyclean.admin.model.resttemplate;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public interface resttemplateCofiguration<E> {

	public RestTemplate getRestTemplate();
	public RestTemplate getRestTemplate(String user,String password);
	public E getRestTemplatePost(E entity,String serviceMethod,String servicePort);
	
}
