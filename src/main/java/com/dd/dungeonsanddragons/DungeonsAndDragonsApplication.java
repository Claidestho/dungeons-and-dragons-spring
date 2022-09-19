
package com.dd.dungeonsanddragons;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DungeonsAndDragonsApplication {


	public static void main(String[] args) {
		SpringApplication.run(DungeonsAndDragonsApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "Bonjour") String name) {
		return String.format("Hello %s!", name);
	}

}
            