package com.izeye.throwaway;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by izeye on 16. 4. 14..
 */
@Data
@NoArgsConstructor
public class ManualAllArgsConstructorDomain {

	private String someProperty;
	
	public ManualAllArgsConstructorDomain(String someProperty) {
		this.someProperty = someProperty;
	}
	
}
