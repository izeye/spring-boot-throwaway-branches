package com.izeye.throwaway.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Vehicle details.
 *
 * @author Johnny Lim
 */
@Data
@AllArgsConstructor
public class VehicleDetails {

	private final String company;
	private final String model;

	@Override
	public String toString() {
		return company + " " + model;
	}

}
