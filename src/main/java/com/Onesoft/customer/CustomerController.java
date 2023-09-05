package com.Onesoft.customer;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;




@RestController
public class CustomerController {
	
	 static Logger log=Logger.getLogger(CustomerController.class);
	
	@Autowired
	CustomerService cSer;
	
    RestTemplate rest =new RestTemplate();
	
	@PostMapping(value="/postifsc")
	public Customer postifsc(@RequestBody Customer c)
	{
		String url="http://localhost:8080/findifscbybank/";
		ResponseEntity<String> res=rest.exchange(url+c.getBranch(), HttpMethod.GET,null,String.class);
		String val=res.getBody();
		
		c.setIfsc(val);
		return cSer.postifsc(c);
		
	
	}
	
	@GetMapping(value="/getlist")
	public List<Customer> getAll() 
	{
		PropertyConfigurator.configure("log.properties");
		log.info(cSer.getAll());
		return cSer.getAll();
	}
	
	@PutMapping(value="nameUpdation")
	
	public Customer nameupdate(@RequestParam int id, @RequestParam String name)
	{
		return cSer.nameupdate(id,name);
	}
	
}
