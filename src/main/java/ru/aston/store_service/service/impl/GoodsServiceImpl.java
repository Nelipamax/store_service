package ru.aston.store_service.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aston.store_service.dto.FromGoodsDto;
import ru.aston.store_service.dto.GoodsDto;
import ru.aston.store_service.feign.GoodsServiceClient;
import ru.aston.store_service.service.GoodsService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GoodsServiceImpl implements GoodsService {

    private final GoodsServiceClient goodsServiceClient;

    @Override
    public List<GoodsDto> getGoodsFromStore(Long id) {
        String dto = goodsServiceClient.getAllGoodsFromStoreWithId(id);
        List<GoodsDto> list = new ArrayList<>();
        GoodsDto g = new GoodsDto(1L, 1L, dto, 1L, BigDecimal.valueOf(1.11));
        list.add(g);
        return list;
    }

    @Override
    public Integer reduceQuantity(List<GoodsDto> goodsDtoList) {
        return goodsServiceClient.reduceQuantities(goodsDtoList).getBody();
    }
}
