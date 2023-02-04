package com.marketplace.Repository;

import com.marketplace.Entity.Household;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseholdRepository extends JpaRepository<Household, Integer>{

}
