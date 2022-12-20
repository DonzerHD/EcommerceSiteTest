package com.ecomerce.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "produit", schema = "ecommerce_test")
@Getter
@Setter
@NoArgsConstructor
public class Produit{
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;
  
  @Column(name = "nom", nullable = false)
  private String nom;
  
  @Column(name = "description", nullable = false)
  private String description;
  
  @Column(name = "prix", nullable = false)
  private double prix;
  
}