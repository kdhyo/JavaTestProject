package com.hyo.story.service.item;

import com.hyo.story.service.item.repository.ItemDslRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, String>, ItemDslRepository {

}
