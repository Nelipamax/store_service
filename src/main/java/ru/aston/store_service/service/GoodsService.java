package ru.aston.store_service.service;

import ru.aston.store_service.dto.GoodsDto;

import java.util.List;

public interface GoodsService {
    List<GoodsDto> getGoodsFromStore(Long id);

    Integer reduceQuantity(List<GoodsDto> goodDtoList);
}
