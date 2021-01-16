package com.enigma.restservice.repositories;

import com.enigma.restservice.entity.classentity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>, TransactionRepoCustom {
}
