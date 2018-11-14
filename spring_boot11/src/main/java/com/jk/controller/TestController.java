package com.jk.controller;


import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jk.model.User;

import com.jk.redis.RedisClient;
import com.jk.service.TestService;

@Controller
public class TestController {

	@Autowired
	TestService testService;

	@Autowired  
	private RedisClient redisClient;
	@Autowired
	private MongoTemplate mongoTemplate;

	
	@RequestMapping(value="/test/{name}/{abcdefg}",method=RequestMethod.GET)
	public  ModelAndView  test(@PathVariable String name,@PathVariable("abcdefg") String a,HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("index");
			/*System.out.println(name +"------"+ a);
			modelAndView.addObject("name", name);
			modelAndView.addObject("list",testService.findTest());
			String msg="";
				testService.testExceptions();*/
			return  modelAndView;
	}
	@RequestMapping(value="/test2")

	public  ModelAndView  test2(){
		ModelAndView modelAndView = new ModelAndView("index");
		System.err.println(1);
		return modelAndView;
	}
	
	@RequestMapping(value="/sele")
    @ResponseBody
	public  List  sele(){
	
		
		List list=testService.sele();
		
		
		
		return list;
	}
	
@RequestMapping(value="/delete/{id}")
@ResponseBody
	public  String delete(@PathVariable String id){
	
	testService.delete(id);

	return "good";
	
		
		
	}



@RequestMapping(value="/seleredis")
@ResponseBody
public  String seleredis(){
	String string="";
	try {
		
		 string = redisClient.get("events");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
return string;
	
	
}


@RequestMapping(value="/addredis/{value}")
@ResponseBody
public  String addredis(@PathVariable String value){
	String string="";
	try {
		
		 redisClient.set("events",value);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
return "succress";

}



@RequestMapping(value="/selemongodb")
@ResponseBody
public  List selemongodb(){
	 Query query = new Query();
     List demoEntity = mongoTemplate.find(query, User.class);
  
return demoEntity;

}

@RequestMapping(value="/addmongodb")
@ResponseBody
public  String addmongodb( String monname){

testService.addmongodb(monname);

return "good";
	
	
}
@RequestMapping(value="/deletes")
@ResponseBody
public  String deletes(){

testService.deletes("1");

return "good";
	
	
}


}
