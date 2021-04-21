package com.zuhlke.avaticaclient.avaticaclient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class AvaticaclientApplicationTests {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Test
	void contextLoads() throws SQLException {

//		DataSource dataSource = (DataSource) jdbcTemplate.getDataSource();
//		System.out.println("Max Idle: " + dataSource.getMaxIdle());
//		System.out.println("Max Active: " + dataSource.getMaxIdle());
//		System.out.println("Active: " + dataSource.getNumActive());
//		System.out.println("Idle: " + dataSource.getNumIdle());
	}

}
