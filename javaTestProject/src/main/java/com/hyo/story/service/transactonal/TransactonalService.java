package com.hyo.story.service.transactonal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyo.story.service.user.UserDTO;

@Service
public class TransactonalService {

	@Transactional
	public void save(UserDTO dto) {
		// query 로직
	}
	
	@Transactional
	public void saveUser(UserDTO dto) {
		this.save(dto);
	}
}

