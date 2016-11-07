package com.izeye.throwaway;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.DirectFieldAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link Application}.
 *
 * @author Johnny Lim
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ApplicationTests {

	@Autowired
	private DataSource dataSource;

	@Test
	public void testHikariJdbcPoolIsNotCreated() throws SQLException {
		assertThat(this.dataSource).isInstanceOf(HikariDataSource.class);

		DirectFieldAccessor dfa = new DirectFieldAccessor(this.dataSource);
		assertThat(dfa.getPropertyValue("pool")).isNull();

		// Create pool via getConnection().
		this.dataSource.getConnection();
		assertThat(dfa.getPropertyValue("pool")).isNotNull();
	}

}