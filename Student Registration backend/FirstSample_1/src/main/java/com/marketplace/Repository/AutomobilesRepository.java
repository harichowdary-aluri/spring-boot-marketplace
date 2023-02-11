package com.marketplace.Repository;

import com.marketplace.Entity.Automobiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomobilesRepository extends JpaRepository<Automobiles, Integer>{

}
