package com.example.src.Dao;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.example.src.Po.Student;
import com.example.src.Po.User;

@Component
public class MongodbDao {

	@Resource(name="primaryMongoTemplate")
	private MongoTemplate primaryMongoTemplate;
	@Resource(name="secondaryMongoTemplate")
	private MongoTemplate secondaryMongoTemplate;
	@Resource
	private MongoDaoUtil mongoDaoUtil;

	public void save(Map<String, Object> userMap) {
		User user = new User();
		user.setLoginName(userMap.get("loginName").toString());
		user.setUserName(userMap.get("userName").toString());
		primaryMongoTemplate.save(user);
	}
	
	public void save2(Map<String, Object> userMap) {
		User user = new User();
		user.setLoginName(userMap.get("loginName").toString());
		user.setUserName(userMap.get("userName").toString());
		secondaryMongoTemplate.save(user);
	}
	
	public void save3() {
		Student stu = new Student();
		stu.setName("张三");
		stu.setId(mongoDaoUtil.getNextSequence("sequence"));
		secondaryMongoTemplate.save(stu);
		System.out.println("已生成ID：" + stu.getId());
	}
}
