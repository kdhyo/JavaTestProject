package com.verification.controller.user;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.verification.dto.user.UserDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	@DisplayName("group valid 성공")
	void success() throws Exception {
		UserDTO user = UserDTO.builder()
			.name("키보드")
			.phone("010-8080-8080")
			.build();

		String userToString = objectMapper.writeValueAsString(user);

		mockMvc.perform(post("/user/groupValid")
				.contentType(MediaType.APPLICATION_JSON)
				.content(userToString))
			.andExpect(status().isOk());
	}

	@Test
	@DisplayName("phone 검증 실패")
	void phone() throws Exception {
		UserDTO user = UserDTO.builder()
			.name("키보드")
			.phone("010-2323-242424")
			.build();

		String userToString = objectMapper.writeValueAsString(user);

		mockMvc.perform(post("/user/groupValid")
				.contentType(MediaType.APPLICATION_JSON)
				.content(userToString))
			.andExpect(status().isBadRequest());
	}

}