package com.hzh.tacocloud;

import com.hzh.tacocloud.domain.entity.Ingredient;
import com.hzh.tacocloud.domain.entity.Ingredient.Type;
import com.hzh.tacocloud.domain.entity.User;
import com.hzh.tacocloud.domain.repository.IngredientRepository;
import com.hzh.tacocloud.domain.repository.OrderRepository;
import com.hzh.tacocloud.domain.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TacoCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacoCloudApplication.class, args);
	}

	@Bean
	@Profile("dev")
	public CommandLineRunner loadData(UserRepository userRepository, PasswordEncoder encoder){
		return args -> {
//			repo.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
//			repo.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
//			repo.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
//			repo.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
//			repo.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
//			repo.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
//			repo.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
//			repo.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
//			repo.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
//			repo.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
			userRepository.deleteAll();
			userRepository.save(new User("test",encoder.encode("test"),"test","test","test","test","test","test"));
		};
	}
}
