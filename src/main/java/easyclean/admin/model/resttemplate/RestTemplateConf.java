package easyclean.admin.model.resttemplate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
@Component
public class RestTemplateConf<E extends Serializable> implements resttemplateCofiguration<E>{

	
	
	@Value("${service.url}")
	private String serviceURL;
	
	

	
	
	@Override
	public RestTemplate getRestTemplate() {
		// TODO Auto-generated method stub
		RestTemplate result = new RestTemplate();		
		return result;
	}

	@Override
	public RestTemplate getRestTemplate(String user, String password) {
		// TODO Auto-generated method stub
			
		return null;
	}

	
	@Override
	public E getRestTemplatePost(E entity, String url,String servicePort) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate();		
		HttpEntity<String> entityHtml = getEntityHtml(entity);		
		System.out.println(entityHtml.toString());
		E postForObject = extracted(entity, url, restTemplate, entityHtml,servicePort);
		return postForObject;
	}
	
	private HttpEntity<String> getEntityHtml(E entity){		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entityHtml = new HttpEntity<String>(getJSONRequest(entity),headers);		
		return entityHtml;
	} 

	@SuppressWarnings("unchecked")
	private E extracted(E entity, String url, RestTemplate restTemplate, HttpEntity<String> entityHtml,String servicePort) {
		return (E) restTemplate.postForObject(serviceURL+":"+servicePort+"/"+url, entityHtml, entity.getClass());
	}
	
	
	
	private String getJSONRequest(E entity){
		String jsonRequest = "";
		try{
			ObjectMapper mapper = new ObjectMapper();			
			jsonRequest = mapper.writeValueAsString(entity);
		}catch(Exception ex){
			
		}
		return jsonRequest;
	}

	

}
