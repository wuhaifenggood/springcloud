package com.example.src.Controller;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dumDataSource")
public class DumDataSourceController {

	@Resource(name="primaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate1;
	
	@Resource(name="secondaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate2;
	
	@PostMapping(value="/checkDataSource")
	public String checkDataSource() {
		jdbcTemplate1.update("insert into mw_warning (mid) values(100)");
		jdbcTemplate2.update("insert into mw_warning (mid) values(200)");
		return "success";
	}
}
