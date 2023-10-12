package ru.aston.storeService.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aston.storeService.dto.GoodsDto;
import ru.aston.storeService.feign.GoodsServiceClient;
import ru.aston.storeService.service.GoodsService;

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
