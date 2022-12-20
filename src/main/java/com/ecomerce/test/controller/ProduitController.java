package com.ecomerce.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecomerce.test.model.Produit;
import com.ecomerce.test.repository.ProduitRepository;

@Controller
public class ProduitController {
  
  @Autowired
  private ProduitRepository produitRepository;
  
  @GetMapping("/produits")
  public String list(Model model) {
    model.addAttribute("produits", produitRepository.findAll());
    return "index";
  }
  
  @GetMapping("/produits/{id}")
  public String detail(@PathVariable Long id, Model model) {
    model.addAttribute("produit", produitRepository.findById(id));
    return "details";
  }
  
  @GetMapping("/produits/create")
  public String create(Model model) {
    model.addAttribute("produit", new Produit());
    return "formulaireProduit";
  }
  
  @PostMapping("/produits/create")
  public String create(Produit produit) {
    produitRepository.save(produit);
    return "redirect:/produits";
  }
  
}
