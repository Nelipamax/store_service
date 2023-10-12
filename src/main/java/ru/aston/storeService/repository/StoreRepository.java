package ru.aston.storeService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aston.storeService.model.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
}