package ru.aston.store_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.aston.store_service.dto.StoreDto;
import ru.aston.store_service.model.Store;

@Mapper
public interface StoreMapper {

    StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);

    StoreDto storeToDto(Store store);
}
