package com.hzh.tacocloud;

import com.hzh.tacocloud.domain.repository.IngredientRepository;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import java.util.Optional;


@SpringBootTest
class TacoCloudApplicationTests {
	@Autowired
	private IngredientRepository ingredientRepository;
	@Test
	void contextLoads() {
	}

	@Data
	@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
	@RequiredArgsConstructor
	class User{
		private String name;
		private final String job;
	}

}
