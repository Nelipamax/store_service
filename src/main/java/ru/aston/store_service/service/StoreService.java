package ru.aston.store_service.service;

import ru.aston.store_service.dto.StoreDto;

import java.util.List;

public interface StoreService {
    List<StoreDto> getStores();
}
