package com.marketplace.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marketplace.Entity.Electronics;

@Repository
public interface ElectronicsRepository extends JpaRepository<Electronics, Integer>{

	Electronics findBysID(String sID);

}
