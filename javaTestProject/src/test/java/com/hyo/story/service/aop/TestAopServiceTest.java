package com.hyo.story.service.aop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = { TestAopService.class, LogAOP.class, LogAOP2.class })
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class TestAopServiceTest {
	
	@Autowired
	TestAopService testAopService;

	@Test
	void test() {
		testAopService.test();
	}

}
