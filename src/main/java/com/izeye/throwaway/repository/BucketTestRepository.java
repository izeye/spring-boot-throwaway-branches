package com.izeye.throwaway.repository;

import com.izeye.throwaway.domain.BucketTest;

/**
 * Repository for {@link BucketTest}.
 *
 * @author Johnny Lim
 */
public interface BucketTestRepository {

	BucketTest getActiveBucketTest(String target);

}
