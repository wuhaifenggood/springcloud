package com.example.src.Controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.src.Dao.MongodbDao;

@RestController
@RequestMapping("/mongo")
public class MongodbTestController {

	@Resource
	private MongodbDao mongodbDao;
	
	@PostMapping("/save")
	public String save(@RequestParam Map<String, Object> userMap) {
		mongodbDao.save(userMap);
		return "success";
	}
	
	@PostMapping("/save2")
	public String save2(@RequestParam Map<String, Object> userMap) {
		mongodbDao.save2(userMap);
		return "success";
	}
	
	@PostMapping("/save3")
	public String save3() {
		mongodbDao.save3();
		return "success";
	}
}
