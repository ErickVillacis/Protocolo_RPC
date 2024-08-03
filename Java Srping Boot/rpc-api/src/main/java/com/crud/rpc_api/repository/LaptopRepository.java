package com.crud.rpc_api.repository;

import com.crud.rpc_api.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
