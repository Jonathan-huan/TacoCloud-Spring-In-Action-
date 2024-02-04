package com.hzh.tacocloud;

import com.hzh.tacocloud.domain.entity.Ingredient;
import com.hzh.tacocloud.domain.entity.Ingredient.Type;
import com.hzh.tacocloud.domain.entity.User;
import com.hzh.tacocloud.domain.repository.IngredientRepository;
import com.hzh.tacocloud.domain.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;

@SpringBootApplication
@Validated
public class TacoCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacoCloudApplication.class, args);
	}

	@Bean
	@Profile({"dev","test"})
	public CommandLineRunner loadData(
			IngredientRepository ingredientRepository,
			UserRepository userRepository,
			PasswordEncoder encoder){
		return args -> {
			ingredientRepository.deleteAll();
			ingredientRepository.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
			ingredientRepository.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
			ingredientRepository.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
			ingredientRepository.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
			ingredientRepository.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
			ingredientRepository.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
			ingredientRepository.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
			ingredientRepository.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
			ingredientRepository.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
			ingredientRepository.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
			userRepository.deleteAll();
			userRepository.save(new User("test",encoder.encode("test"),"test","test","test","test","test","test"));
		};
	}

}
