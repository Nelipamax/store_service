package ru.aston.store_service.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aston.store_service.dto.GoodsDto;
import ru.aston.store_service.feign.GoodsServiceClient;
import ru.aston.store_service.service.GoodsService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GoodsServiceImpl implements GoodsService {

    private final GoodsServiceClient goodsServiceClient;

    @Override
    public List<GoodsDto> getGoodsFromStore(Long id) {
        return goodsServiceClient.getAllGoodsFromStoreWithId(id);
    }

    @Override
    public Integer reduceQuantity(List<GoodsDto> goodsDtoList) {
        return goodsServiceClient.reduceQuantities(goodsDtoList).getBody();
    }
}
