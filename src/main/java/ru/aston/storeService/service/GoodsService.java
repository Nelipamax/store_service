package ru.aston.storeService.service;

import ru.aston.storeService.dto.GoodsDto;

import java.util.List;

public interface GoodsService {
    List<GoodsDto> getGoodsFromStore(Long id);

    Integer reduceQuantity(List<GoodsDto> goodsDtoList);
}
