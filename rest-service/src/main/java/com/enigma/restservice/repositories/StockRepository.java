package com.enigma.restservice.repositories;

import com.enigma.restservice.entity.classentity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StockRepository extends JpaRepository<Stock, Integer>, StockRepositoryCustom {

}
