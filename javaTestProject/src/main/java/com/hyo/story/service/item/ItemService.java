package com.hyo.story.service.item;


import com.querydsl.core.group.Group;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public ItemEntity save(ItemEntity entity) {
        return itemRepository.save(entity);
    }

    public Map<String, Integer> getQuantity() {
        return itemRepository.getQuantity();
    }

    @Transactional(readOnly = true)
    public Map<String, Group> groupMap() {
        return itemRepository.getGroup();
    }

}
