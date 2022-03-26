package com.verification.controller.item;

import com.verification.dto.item.ItemDTO;
import com.verification.service.item.ItemService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/item")
public class ItemController {

	private final ItemService itemService;

	@PostMapping(value = "/save")
	public ResponseEntity<String> save(@Valid @RequestBody ItemDTO itemDTO) {
		itemService.save(itemDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
