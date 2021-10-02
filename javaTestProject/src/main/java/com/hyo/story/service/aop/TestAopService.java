package com.hyo.story.service.aop;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Service
public class TestAopService {
	
	public void test() {
		log.error("로직동작");
	}

}
