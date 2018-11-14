package com.jk.service;


import java.util.List;

import com.jk.model.User;


public interface TestService  {

	List sele();

	void delete(String id);

	void add(String name, String monreg);

	void update(String id, String name, String monreg);
	void addmongodb(String monname);
	List selemongodb();
	void deletemons(String id);
	User toupdate(String id);
	void updatemon(String id, String name);
	User toindexupdate(String id);
	
	
	
	List seles();

	void deletes(String id);

	void adds(String name, String monreg);


}
