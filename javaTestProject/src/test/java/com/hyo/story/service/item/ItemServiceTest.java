package com.hyo.story.service.item;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
@Rollback(false)
class ItemServiceTest {

	@Autowired
	private ItemService itemService;

	@Test
	void itemSaveTestCreatedMode() {
		for(var i = 0; i < 100000; i++) {
			itemService.save(ItemEntity.builder().itemId("createdModeTEST" + i).itemName("createdModeTEST").color("red").isCreatedMode(true).build());
		}
	}

	@Test
	void itemSaveTestNotCreatedMode() {
		for(var i = 0; i < 100000; i++) {
			itemService.save(ItemEntity.builder().itemId("notCreatedModeTEST" + i).itemName("notCreatedModeTEST").color("red").isCreatedMode(false).build());
		}
	}

}
