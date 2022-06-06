package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PanelDemoApplication {  //implements CommandLineRunner
	/* private final LoginRepository loginRepository;

	public PanelDemoApplication(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}

	 */

	public static void main(String[] args) {
		SpringApplication.run(PanelDemoApplication.class, args);
	}
	/*
	@Override
	public void run(String... args) throws Exception {
		loginRepository.save(new User(1L,"Naciye","naciye.aydin@sahabt.com","123456"));
	}*/
}
