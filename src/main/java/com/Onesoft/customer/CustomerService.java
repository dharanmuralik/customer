package com.Onesoft.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	
	@Autowired
	CustomerDao cDao;
	
	public Customer postifsc( Customer c)
	{
		return cDao.postifsc(c);
	}
	
	public List<Customer> getAll() 
	{
		return cDao.getAll();
	}

	public Customer nameupdate( int id,String name)
	{
		return cDao.nameupdate(id,name);
	}

}
