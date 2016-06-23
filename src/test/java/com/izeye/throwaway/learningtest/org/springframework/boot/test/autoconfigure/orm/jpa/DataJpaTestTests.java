package com.izeye.throwaway.learningtest.org.springframework.boot.test.autoconfigure.orm.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by izeye on 16. 6. 23..
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class DataJpaTestTests {
	
	@Test
	public void test() {
		assertThat(TransactionSynchronizationManager.isActualTransactionActive()).isTrue();
	}
	
	@Test
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void testNonTransactional() {
		assertThat(TransactionSynchronizationManager.isActualTransactionActive()).isFalse();
	}
	
}
