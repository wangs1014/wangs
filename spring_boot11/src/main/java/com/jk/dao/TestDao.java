package com.jk.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;

import com.jk.model.User;
@Mapper
public interface TestDao {
	
	List sele();

	void delete(@Param("id")String id);

	void add(@Param("user")User user);

	void update(@Param("id")String id, @Param("name")String name, @Param("monreg")String monreg);

	User toindexupdate(@Param("id")String id);

}
