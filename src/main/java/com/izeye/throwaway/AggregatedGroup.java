package com.izeye.throwaway;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by izeye on 16. 3. 10..
 */
public interface AggregatedGroup {
	
	long getId();
	
	String getName();
	
}
