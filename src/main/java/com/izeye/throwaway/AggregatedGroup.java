package com.izeye.throwaway;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by izeye on 16. 3. 10..
 */
@Entity
@Data
@AllArgsConstructor
public class AggregatedGroup {
	
	@Id
	private Long id;
	
	private String name;
	
}
