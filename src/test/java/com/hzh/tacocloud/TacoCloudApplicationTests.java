package com.hzh.tacocloud;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


@SpringBootTest
class TacoCloudApplicationTests {

	@Test
	void contextLoads() {
		Object b=Optional.ofNullable(null).orElse(null);
	}

}
