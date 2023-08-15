package com.Onesoft.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {
	
	@Autowired
	CustomerRepository cRepo;
	
	public Customer postifsc( Customer c)
	{
		
	Customer d=	cRepo.save(c);
		return d;
	}


	public Customer nameupdate( int id,String name)
	{
	Customer d=cRepo.findById(id).get();
	
	d.setName(name);
	
	cRepo.save(d);
	return d;	
	}

}
