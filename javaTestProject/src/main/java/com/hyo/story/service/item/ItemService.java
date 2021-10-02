package com.hyo.story.service.item;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {

	private final ItemRepository itemRepository;

	@Transactional
	public ItemEntity save(ItemEntity entity) {
		return itemRepository.save(entity);
	}

}
