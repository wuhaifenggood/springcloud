package com.example.src.Controller;

import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.src.Po.User;
import com.example.src.Service.IUserService;

@RestController
public class HelloWorldController {

	@Value("${com.neo.title}")
	private String title;
	@Value("${com.neo.description}")
	private String description;
	
	@Resource
	private IUserService userService;
	@Resource
	private RedisTemplate<String, Object> redisTemplate;
	
	@RequestMapping("/hello")
	public String index() {
		System.out.println("title====================="+title);
		System.out.println("description====================="+description);
		return "hello world";
	}
	
	@RequestMapping(value="/getUser")
	@Cacheable(value="users", key="'user_'+#id")
	public User getUser(Long id) {
		User user = userService.selectOne(id);
		System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
		return user;
	}
	
	@RequestMapping(value="/findUser")
	@Cacheable(value="users", key="#id")
    public User findUser(Integer id) {
		//boolean isHas = redisTemplate.hasKey("users_"+id);
		User user = (User)redisTemplate.opsForValue().get("'users_'"+id);
		if(user == null) {
			user = new User();
			user.setLoginName("hlhdidreqreqri");
			user.setPassword("12343214321");
			user.setId(id.longValue());
			System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
		}
        return user;
    }
	
	@RequestMapping(value="/redisUser")
	public User redisUser(Long id) {
		User user = (User)redisTemplate.opsForValue().get("users_"+id);
		if(user == null) {
			user = new User();
			user.setLoginName("hlhdidreqreqri");
			user.setPassword("12343214321");
			user.setId(id.longValue());
			System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
			redisTemplate.opsForValue().set("users_"+id, user);
		}
        return user;
	}

	@RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
            System.out.println("uid is null");
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }
}