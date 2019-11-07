package com.izeye.throwaway.service;

import com.izeye.throwaway.domain.VehicleDetails;

/**
 * Service for user vehicles.
 *
 * @author Johnny Lim
 */
public interface UserVehicleService {

	VehicleDetails getVehicleDetails(String username);

}
