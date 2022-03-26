package com.verification.controller.user;

import com.verification.dto.user.UserDTO;
import com.verification.service.user.UserService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

	private final UserService userService;

	@PostMapping(value = "/groupValid")
	public ResponseEntity<String> groupValid(@RequestBody UserDTO userDTO) {
		userService.groupValid(userDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping(value = "/validated")
	public ResponseEntity<String> validated(@RequestBody UserDTO userDTO) {
		userService.validated(userDTO);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
