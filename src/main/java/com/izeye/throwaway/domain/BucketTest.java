package com.izeye.throwaway.domain;

import java.util.List;

import lombok.Data;

/**
 * Bucket test.
 *
 * @author Johnny Lim
 */
@Data
public class BucketTest {

	private int id;
	private String name;
	private List<String> targets;

}
