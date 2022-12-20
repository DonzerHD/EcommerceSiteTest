package com.ecomerce.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomerce.test.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long>{

}
