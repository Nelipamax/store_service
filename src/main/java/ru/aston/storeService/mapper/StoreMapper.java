package ru.aston.storeService.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.aston.storeService.dto.StoreDto;
import ru.aston.storeService.model.Store;

@Mapper
public interface StoreMapper {

    StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);

    StoreDto storeToDto(Store store);
}
