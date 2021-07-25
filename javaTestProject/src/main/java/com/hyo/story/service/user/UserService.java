package com.hyo.story.service.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyo.story.service.transactonal.TransactonalService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final TransactonalService transactonalService;
	
	@Transactional
	public void saveUser(UserDTO dto) {
		transactonalService.save(dto);
	}

}
