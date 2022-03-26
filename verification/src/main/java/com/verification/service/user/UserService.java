package com.verification.service.user;

import com.verification.dto.user.CreateUser;
import com.verification.dto.user.UserDTO;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Service
@Validated
public class UserService {

	@Validated(CreateUser.class)
	public void groupValid(@Valid UserDTO userDTO) {
		log.info(userDTO.toString());
	}

	public void validated(@Valid UserDTO userDTO) {
		log.info(userDTO.toString());
	}

}
