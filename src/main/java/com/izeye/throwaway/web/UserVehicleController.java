package com.izeye.throwaway.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.izeye.throwaway.service.UserVehicleService;

/**
 * {@link RestController} for user vehicles.
 *
 * @author Johnny Lim
 */
@RestController
public class UserVehicleController {

	@Autowired
	private UserVehicleService userVehicleService;

	@GetMapping(path = "/{username}/vehicle")
	public String getVehicle(@PathVariable String username) {
		return this.userVehicleService.getVehicleDetails(username).toString();
	}

}
