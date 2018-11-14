package com.jk.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.jk.dao.TestDao;
import com.jk.model.User;
import com.jk.redis.RedisClient;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service("testService")
@Transactional(readOnly=true)
public class TestServiceImpl implements  TestService{

	@Autowired
	TestDao testDao;
	@Autowired  
	private RedisClient redisClient;
	@Autowired
	private MongoTemplate mongoTemplate;
	@Override
	public List sele() {
		// TODO Auto-generated method stub
		List list=testDao.sele();
		try {
			redisClient.set("list", JSONArray.toJSONString(list));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				return list;
	}

	@Transactional(readOnly=false)
	public void delete(String id) {
		// TODO Auto-generated method stub
		testDao.delete(id);
	}

	@Transactional(readOnly=false)
	public void add(String name,String monreg) {
		User user =new User();
		user.setId(UUID.randomUUID().toString());
		user.setName(name);
		user.setRegion(monreg);
		testDao.add(user);
	}

	@Transactional(readOnly=false)
	public void update(String id,String name,String monreg) {
		testDao.update(id,name,monreg);		
	}

	@Override
	public void addmongodb(String monname) {
		User user=new User();
		user.setId(UUID.randomUUID().toString());
		user.setName(monname);
		mongoTemplate.insert(user);
		
	}

	@Override
	public List selemongodb() {
		// TODO Auto-generated method stub
		return mongoTemplate.find(null, User.class);
	}

	@Override
	public void deletemons(String id) {
		
		mongoTemplate.remove(new Query(Criteria.where("id").is(id)), User.class);
		
	}

	@Override
	public User toupdate(String id) {
		// TODO Auto-generated method stub
		return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)), User.class);
	}
	
	@Override
	public void updatemon(String id, String name) {
		Update update=new Update();
		update.set("name", name);
		mongoTemplate.updateFirst(new Query(Criteria.where("id").is(id)), update, User.class);
		
	}

	@Override
	public User toindexupdate(String id) {
		// TODO Auto-generated method stub
		return testDao.toindexupdate(id);
	}

	@Override
	public List seles() {
		String string="";
		 try {
			 string = redisClient.get("list");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   List<User> parseArray = JSONArray.parseArray(string, User.class);
		return parseArray;
	}

	@Override
	public void deletes(String id) {
		JedisPool jedisPool = redisClient.getJedisPool();
		Jedis jedis = jedisPool.getResource();
		Long del = jedis.del("list");
		
	}

	@Override
	public void adds(String name, String monreg) {
		// TODO Auto-generated method stub
		
	}

	
	
	

}
