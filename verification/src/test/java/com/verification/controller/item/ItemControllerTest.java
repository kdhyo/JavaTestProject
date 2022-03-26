package com.verification.controller.item;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.verification.dto.item.ItemDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	@DisplayName("valid 성공")
	void success() throws Exception {
		ItemDTO item = ItemDTO.builder()
			.id(1L)
			.itemName("키보드")
			.quantity(10)
			.build();

		String itemToString = objectMapper.writeValueAsString(item);

		mockMvc.perform(post("/item/save")
				.contentType(MediaType.APPLICATION_JSON)
				.content(itemToString))
			.andExpect(status().isCreated());
	}

	@Test
	@DisplayName("itemName null")
	void nullName() throws Exception {
		ItemDTO item = ItemDTO.builder()
			.id(1L)
			.quantity(10)
			.build();

		String itemToString = objectMapper.writeValueAsString(item);

		mockMvc.perform(post("/item/save")
				.contentType(MediaType.APPLICATION_JSON)
				.content(itemToString))
			.andExpect(status().isBadRequest());
	}

	@Test
	@DisplayName("itemName empty")
	void emptyName() throws Exception {
		ItemDTO item = ItemDTO.builder()
			.id(1L)
			.itemName("")
			.quantity(10)
			.build();

		String itemToString = objectMapper.writeValueAsString(item);

		mockMvc.perform(post("/item/save")
				.contentType(MediaType.APPLICATION_JSON)
				.content(itemToString))
			.andExpect(status().isBadRequest());
	}

	@Test
	@DisplayName("itemName blank")
	void blankName() throws Exception {
		ItemDTO item = ItemDTO.builder()
			.id(1L)
			.itemName("  ")
			.quantity(10)
			.build();

		String itemToString = objectMapper.writeValueAsString(item);

		mockMvc.perform(post("/item/save")
				.contentType(MediaType.APPLICATION_JSON)
				.content(itemToString))
			.andExpect(status().isBadRequest());
	}

	@Test
	@DisplayName("quantity 최소 값")
	void minQuantity() throws Exception {
		ItemDTO item = ItemDTO.builder()
			.id(1L)
			.itemName("키보드")
			.quantity(0)
			.build();

		String itemToString = objectMapper.writeValueAsString(item);

		mockMvc.perform(post("/item/save")
				.contentType(MediaType.APPLICATION_JSON)
				.content(itemToString))
			.andExpect(status().isBadRequest());
	}

	@Test
	@DisplayName("quantity 최대 값")
	void maxQuantity() throws Exception {
		ItemDTO item = ItemDTO.builder()
			.id(1L)
			.itemName("키보드")
			.quantity(101)
			.build();

		String itemToString = objectMapper.writeValueAsString(item);

		mockMvc.perform(post("/item/save")
				.contentType(MediaType.APPLICATION_JSON)
				.content(itemToString))
			.andExpect(status().isBadRequest());
	}

}