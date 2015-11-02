package com.izeye.throwaway;

import lombok.Data;

/**
 * Created by izeye on 15. 11. 2..
 */
@Data
public class Banana extends Fruit {

	private String bananaSpecificPropertyIfAny;
	
	public Banana() {
	}
	
	public Banana(String bananaSpecificPropertyIfAny) {
		super("banana");
		
		this.bananaSpecificPropertyIfAny = bananaSpecificPropertyIfAny;
	}
	
}
