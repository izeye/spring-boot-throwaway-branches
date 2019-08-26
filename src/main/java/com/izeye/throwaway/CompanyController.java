package com.izeye.throwaway;

import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

	@GetMapping("/company")
	public Company getCompany() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		return new Company(1L, "CTB");
	}

}
