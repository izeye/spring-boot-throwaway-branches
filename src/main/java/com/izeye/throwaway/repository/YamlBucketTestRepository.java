package com.izeye.throwaway.repository;

import java.util.List;

import lombok.Data;

import com.izeye.throwaway.domain.BucketTest;

/**
 * YAML-based {@link BucketTestRepository}.
 *
 * @author Johnny Lim
 */
@Data
public class YamlBucketTestRepository implements BucketTestRepository {

	private List<BucketTest> bucketTests;

	@Override
	public BucketTest getActiveBucketTest(String target) {
		for (BucketTest bucketTest : this.bucketTests) {
			if (bucketTest.getTargets().contains(target)) {
				return bucketTest;
			}
		}
		return null;
	}

}
