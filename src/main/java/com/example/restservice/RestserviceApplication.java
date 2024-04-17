package com.example.restservice;

import com.example.restservice.models.Ingredient;
import com.example.restservice.models.Ingredient.Type;
import com.example.restservice.repos.IngredientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestserviceApplication.class, args);
	}

	// Two interfaces for executing logic when an app starts up:
	//   - CommandLineRunner
	//   - ApplicationRunner
	// Both require `run()` implementation
	// Can be declared as beans by being functions that return lambda function
	// these interfaces accept single parameter that represents all command-line args
	//   - Difference b/w the two
	//     - commandlinerunner just accepts raw varargs
	//     - applicationrunner accepts args as ApplicationArguments object
	@Bean
	public CommandLineRunner dataLoader(IngredientRepository repo) {
		return args -> {
			repo.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
			repo.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
			repo.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
			repo.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
			repo.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
			repo.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
			repo.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
			repo.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
			repo.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
			repo.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
		};
	}

}
