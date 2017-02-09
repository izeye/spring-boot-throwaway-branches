package com.izeye.throwaway.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link BucketTestRepository}.
 *
 * @author Johnny Lim
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class BucketTestRepositoryTests {

	@Autowired
	private BucketTestRepository bucketTestRepository;

	@Test
	public void testGetActiveBucketTest() {
		System.out.println(this.bucketTestRepository);

		assertThat(this.bucketTestRepository.getActiveBucketTest("a")).isNotNull();
		assertThat(this.bucketTestRepository.getActiveBucketTest("b")).isNotNull();
		assertThat(this.bucketTestRepository.getActiveBucketTest("c")).isNull();
	}

}
