package com.tasly.product.db.reposity;

import com.tasly.product.db.domain.Product;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dulei on 18/1/8.
 */
public interface ProductReposity extends JpaRepository<Product,Long> {

}
