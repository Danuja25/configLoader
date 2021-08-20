package org.danuja25.configloader;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Configurations API", version = "1.0", description = "Manage configurations of the system"))
public class ConfigLoaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigLoaderApplication.class, args);
	}

}
