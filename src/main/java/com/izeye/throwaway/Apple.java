package com.izeye.throwaway;

import lombok.Data;

/**
 * Created by izeye on 15. 11. 2..
 */
@Data
public class Apple extends Fruit {
	
	private String appleSpecificPropertyIfAny;
	
	public Apple() {
	}
	
	public Apple(String appleSpecificPropertyIfAny) {
		super("apple");
		
		this.appleSpecificPropertyIfAny = appleSpecificPropertyIfAny;
	}
	
}
