package com.less;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
class LessApplicationTests {
	Logger logger = LoggerFactory.getLogger(LessApplicationTests.class);

	@Test
	void contextLoads() {
		logger.info("Junit Test. {}", new Date());
	}

}
