package ru.aston.store_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.aston.store_service.model.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
}
