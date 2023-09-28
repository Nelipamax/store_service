package ru.aston.store_service.service.impl;

import org.springframework.stereotype.Service;
import ru.aston.store_service.dto.StoreDto;
import ru.aston.store_service.mapper.StoreMapper;
import ru.aston.store_service.model.Store;
import ru.aston.store_service.repository.StoreRepository;
import ru.aston.store_service.service.StoreService;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    
    private final StoreRepository repository;

    @Override
    public List<StoreDto> getStores() {

        List<StoreDto> stores = new ArrayList<>();
        List<Store> storesEntity = repository.findAll();
        for (Store store : storesEntity) {
            stores.add(StoreMapper.INSTANCE.storeToDto(store));
        }

        return stores;
    }

    public StoreServiceImpl(StoreRepository repository) {
        this.repository = repository;
    }
}
