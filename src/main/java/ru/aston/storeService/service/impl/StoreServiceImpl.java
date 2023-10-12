package ru.aston.storeService.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aston.storeService.dto.StoreDto;
import ru.aston.storeService.mapper.StoreMapper;
import ru.aston.storeService.model.Store;
import ru.aston.storeService.repository.StoreRepository;
import ru.aston.storeService.service.StoreService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
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
}
