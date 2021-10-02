package com.hyo.story.controller.aop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.hyo.story.service.aop.TestAopService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AopController {
	
	private final TestAopService testAopService;
	
	@GetMapping("/test")
	public void test() {
		testAopService.test();
	}

}
