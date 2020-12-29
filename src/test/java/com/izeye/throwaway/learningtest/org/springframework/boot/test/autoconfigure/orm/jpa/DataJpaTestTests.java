package com.izeye.throwaway.learningtest.org.springframework.boot.test.autoconfigure.orm.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link DataJpaTest}.
 *
 * @author Johnny Lim
 */
@DataJpaTest
class DataJpaTestTests {
	
	@Test
	void test() {
		assertThat(TransactionSynchronizationManager.isActualTransactionActive()).isTrue();
	}
	
	@Test
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	void testNonTransactional() {
		assertThat(TransactionSynchronizationManager.isActualTransactionActive()).isFalse();
	}
	
}
