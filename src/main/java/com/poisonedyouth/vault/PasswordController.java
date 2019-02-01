package com.poisonedyouth.vault;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordController {

	@Value("${password: n/a}")
	String password = "n/a";

	@RequestMapping("/")
	public String home() {
		return "Your password is " + password;
	}
}
