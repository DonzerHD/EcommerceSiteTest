package com.ecomerce.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ecomerce.test.model.Produit;
import com.ecomerce.test.repository.ProduitRepository;

@Controller
public class ProduitController {
  
  @Autowired
  private ProduitRepository produitRepository;
  
  @GetMapping("/")
  public String list(Model model) {
    model.addAttribute("produits", produitRepository.findAll());
    return "index";
  }
  
  @GetMapping("/produit/detail/{id}")
  public ModelAndView detail(@PathVariable Long id) {
	   Produit produit = produitRepository.findById(id).orElseThrow();
	    ModelAndView modelAndView = new ModelAndView("details");
	    modelAndView.addObject("produit", produit);
    return modelAndView;
  }
  
  @GetMapping("/produits/create")
  public String create(Model model) {
    model.addAttribute("produit", new Produit());
    return "formulaireProduit";
  }
  
  @PostMapping("/produits/create")
  public String create(Produit produit) {
    produitRepository.save(produit);
    return "redirect:/";
  }
 
  @GetMapping("/produit/edit/{id}")
  public ModelAndView editObjet(@PathVariable Long id) {
	   Produit produit = produitRepository.findById(id).orElseThrow();
	    ModelAndView modelAndView = new ModelAndView("edit");
	    modelAndView.addObject("produit", produit);
    return modelAndView;
  }
  
  @PostMapping("/produit/edit/{id}")
  public String updateObject(@PathVariable Long id,Produit produit,BindingResult result) {
      if (result.hasErrors()) {
          return "edit_object";
      }
      produitRepository.save(produit);
      return "redirect:/";
  }
  
}
