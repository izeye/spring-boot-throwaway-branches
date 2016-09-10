package com.izeye.throwaway.autoconfigure.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link JdbcTest}.
 *
 * @author Johnny Lim
 */
@RunWith(SpringRunner.class)
@JdbcTest
public class JdbcTestTests {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void test() {
		this.jdbcTemplate.execute("CREATE TABLE employee (id int, name varchar)");
		this.jdbcTemplate.execute("INSERT INTO employee (id, name) VALUES (1, 'Johnny Lim')");
		List<Map<String, Object>> employees =
				this.jdbcTemplate.queryForList("SELECT id, name FROM employee");
		assertThat(employees).hasSize(1);
	}

}
