package com.hyo.story.service.item.repository;

import com.querydsl.core.group.Group;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDslRepository {

    Map<String, Group> getGroup();

    Map<String, Integer> getQuantity();

}
