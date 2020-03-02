package com.izeye.throwaway.service;

import javax.annotation.PostConstruct;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Service for testing {@link JdbcTemplate}.
 *
 * @author Johnny Lim
 */
@Service
public class JdbcTemplateTestService {

	private final JdbcTemplate jdbcTemplate;

	public JdbcTemplateTestService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@PostConstruct
	public void init() {
		String firstSql = "SELECT 1";
		System.out.println(firstSql + " => " + this.jdbcTemplate.queryForObject(firstSql, Object.class));
		String secondSql = "SELECT first_name FROM person WHERE last_name = 'Lim';";
		System.out.println(secondSql + " => " + this.jdbcTemplate.queryForObject(secondSql, Object.class));

	}

}
