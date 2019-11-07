package com.izeye.throwaway.service;

import org.springframework.stereotype.Service;

import com.izeye.throwaway.domain.VehicleDetails;

/**
 * Default {@link UserVehicleService}.
 *
 * @author Johnny Lim
 */
@Service
public class DefaultUserVehicleService implements UserVehicleService {

	@Override
	public VehicleDetails getVehicleDetails(String username) {
		throw new RuntimeException("Intentional error.");
	}

}
