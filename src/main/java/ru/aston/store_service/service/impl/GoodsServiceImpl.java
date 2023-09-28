package ru.aston.store_service.service.impl;

import org.springframework.stereotype.Service;
import ru.aston.store_service.dto.GoodsDto;
import ru.aston.store_service.feign.GoodsServiceClient;
import ru.aston.store_service.service.GoodsService;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    private final GoodsServiceClient client;

    @Override
    public List<GoodsDto> getGoodsFromStore(Long id) {

        return client.goods(id.toString());
    }

    public GoodsServiceImpl(GoodsServiceClient client) {
        this.client = client;
    }
}
