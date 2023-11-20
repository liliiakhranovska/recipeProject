package com.kvitka.recipeproject.controllers;

import com.kvitka.recipeproject.domain.Category;
import com.kvitka.recipeproject.domain.Recipe;
import com.kvitka.recipeproject.domain.UnitOfMeasure;
import com.kvitka.recipeproject.repositories.CategoryRepository;
import com.kvitka.recipeproject.repositories.RecipeRepository;
import com.kvitka.recipeproject.repositories.UnitOfMeasureRepository;
import com.kvitka.recipeproject.services.RecipeService;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

//    private CategoryRepository categoryRepository;
//    private UnitOfMeasureRepository unitOfMeasureRepository;
    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    //    @RequestMapping({"", "/", "/index"})
//    public String getIndexPage() {
//
//        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
//        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
//
//        System.out.println("Cat Id is: " + categoryOptional.get().getId());
//        System.out.println("UOM Id is: " + unitOfMeasureOptional.get().getId());
//        return "index";
//    }

    @RequestMapping({"", "/", "/index"})
    public String getRecipes(Model model) {

        model.addAttribute("recipes", recipeService.findAll());

        RabbitConnectionDetails.Address()
        return "index";
    }
}
