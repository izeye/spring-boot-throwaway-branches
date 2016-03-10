package com.izeye.throwaway;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by izeye on 16. 3. 10..
 */
@Entity
@Data
public class SomeGroup {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
}
