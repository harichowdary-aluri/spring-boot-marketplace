package com.productregistration.Repository;

import com.productregistration.Entity.ImageModel;
import com.productregistration.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageModel,Long> {
}
