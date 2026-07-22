package com.momin.classproject2;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequestMapping("/product")
@Controller
public class IndexController {
    private  final List<Product> products = new ArrayList<>();


    @GetMapping("/add")
    public String showForm(Model model){
        model.addAttribute("name", "Mr Java");
        model.addAttribute("product", new Product());
        return "product";
    }

    @PostMapping("/add")
    public String submit(@Valid @ModelAttribute Product product, BindingResult bindingResult){
        log.info("form {} is submitted",product);
        if(bindingResult.hasErrors()){
            return "product";
        }

        products.add(product);
        return "redirect:/product/add";
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("productList", products);
        return "list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model){
        log.info("Editing product with id: {}", id);
        
        Product existingProduct = products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (existingProduct == null) {
            return "redirect:/product/list";
        }

        model.addAttribute("name", "Edit Product");
        model.addAttribute("product", existingProduct);

        return "product";
    }

}
