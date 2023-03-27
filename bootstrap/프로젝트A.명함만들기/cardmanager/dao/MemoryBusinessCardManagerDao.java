package org.edwith.webbe.cardmanager.dao;

import org.edwith.webbe.cardmanager.dto.BusinessCard;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MemoryBusinessCardManagerDao implements BusinessCardManagerDao{

    private Map<Long, BusinessCard> store = new HashMap();

    private Long sequence = 0L;

    @Override
    public List<BusinessCard> searchBusinessCard(String keyword) {
        List<BusinessCard> list = store.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(e -> e.getName().startsWith(keyword))
                .collect(Collectors.toList());

        return list;
    }

    @Override
    public BusinessCard addBusinessCard(BusinessCard businessCard) {
        businessCard.setCreateDate(new Date());

        store.put(sequence++, businessCard);

        return businessCard;
    }
}
