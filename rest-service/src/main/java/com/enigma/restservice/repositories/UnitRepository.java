package com.enigma.restservice.repositories;

import com.enigma.restservice.entity.classentity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Integer> {

}
