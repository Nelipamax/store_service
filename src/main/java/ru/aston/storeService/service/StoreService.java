package ru.aston.storeService.service;

import ru.aston.storeService.dto.StoreDto;

import java.util.List;

public interface StoreService {
    List<StoreDto> getStores();
}
