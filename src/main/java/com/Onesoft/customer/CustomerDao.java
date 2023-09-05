package com.Onesoft.customer;

import java.util.List;

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

	public List<Customer> getAll() 
	{
		List<Customer> lists=cRepo.findAll();
		return lists;
	}

	public Customer nameupdate( int id,String name)
	{
	Customer d=cRepo.findById(id).get();
	
	d.setName(name);
	
	cRepo.save(d);
	return d;	
	}

}
