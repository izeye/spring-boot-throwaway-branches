package com.izeye.throwaway;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.DirectFieldAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Integration tests for {@link DataSource}.
 *
 * @author Johnny Lim
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles("test")
public class ProfileIntegrationTests {

	@Autowired
	private DataSource dataSource;

	@Test
	public void testTomcatJdbcPoolIsNotCreated() throws SQLException {
		DirectFieldAccessor dfa = new DirectFieldAccessor(this.dataSource);
		assertThat(dfa.getPropertyValue("pool")).isNull();

		// Create pool explicitly.
		((org.apache.tomcat.jdbc.pool.DataSource) this.dataSource).createPool();
		assertThat(dfa.getPropertyValue("pool")).isNotNull();
	}

}
