package com.hzh.tacocloud;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


@SpringBootTest
class TacoCloudApplicationTests {

	@Test
	void contextLoads() {
		User user = new User();
		System.out.println(user);
	}

	@Data
	@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
	@RequiredArgsConstructor
	class User{
		private String name;
		private final String job;
	}

}
