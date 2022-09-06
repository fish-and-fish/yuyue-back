package com.example.tacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.example.tacao.dao.IngredientDao;
import com.example.tacao.dao.IngredientDao;
import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/design")
@ConfigurationProperties(prefix = "taco.orders")
public class showDesign {

    private String name;

    public void setName(String name){
        this.name = name;
    }

    @Autowired
    IngredientDao ingredientDao;

    @GetMapping
    public String showDesign(Model model){
        List<Ingredient> ingredients = Lists.newArrayList(ingredientDao.findByName(name));
        model.addAttribute("design", ingredients);
        return "design";
    }
}
