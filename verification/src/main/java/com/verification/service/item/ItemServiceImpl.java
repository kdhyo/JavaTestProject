package com.verification.service.item;

import com.verification.dto.item.ItemDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ItemServiceImpl implements ItemService {

	@Override
	public void save(ItemDTO itemDTO) {
		if (itemDTO == null) {
			throw new IllegalArgumentException("아이템 정보가 존재하지 않습니다.");
		}

		if (itemDTO.getItemName() == null || itemDTO.getItemName().isEmpty()) {
			throw new IllegalArgumentException("아이템 명은 필수 입니다.");
		}

		if (itemDTO.getQuantity() == null) {
			throw new IllegalArgumentException("아이템 개수는 필수 입니다.");
		}

		if (itemDTO.getQuantity() < 1) {
			throw new IllegalArgumentException("아이템 개수는 1 이상 이어야 합니다.");
		}

		if (itemDTO.getQuantity() > 100) {
			throw new IllegalArgumentException("아이템 개수는 100 이하여야 합니다.");
		}

		// 비지니스 로직 진행
	}

}
