package org.example.jobsight;

import me.paulschwarz.springdotenv.DotenvPropertySource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class JobSightApplication {


	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(JobSightApplication.class);

		ConfigurableEnvironment environment = app.run(args).getEnvironment();

		DotenvPropertySource.addToEnvironment(environment);

//		String user = environment.getProperty("POSTGRES_USER");
//		String pass = environment.getProperty("POSTGRES_PASSWORD");
//
//		System.out.println(user);
//		System.out.println(pass);


	}

}
