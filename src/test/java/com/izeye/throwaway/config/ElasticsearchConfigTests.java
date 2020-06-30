package com.izeye.throwaway.config;

import javax.annotation.Resource;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for Elasticsearch configurations.
 *
 * @author Johnny Lim
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ElasticsearchConfigTests {

	@Resource
	private TransportClient firstTransportClient;

	@Resource
	private TransportClient secondTransportClient;

	@Test
	void test() {
		assertThat(this.firstTransportClient.getClusterName()).isEqualTo("first");
		assertThat(this.secondTransportClient.getClusterName()).isEqualTo("second");
	}

}
