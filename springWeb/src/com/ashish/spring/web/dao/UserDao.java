package com.ashish.spring.web.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("userDao")
public class UserDao {

	private NamedParameterJdbcTemplate	jdbc;

	public NamedParameterJdbcTemplate getJdbc() {
		return jdbc;
	}

	public UserDao() {
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	@Transactional
	public boolean create(User user) {
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(user);
		jdbc.update("insert into users (username,password,email, enabled) value (:username,:password,:email,:enabled)", param);
		return jdbc.update("insert into authorities (username, authority) value (:username,:authority)", param) == 1;
	}

	/**
	 * @return
	 */
	public boolean exists(String username) {
		return jdbc.queryForObject("select count(*) from users where username = :username", new MapSqlParameterSource("username", username),
				Integer.class) > 0;
	}

}
