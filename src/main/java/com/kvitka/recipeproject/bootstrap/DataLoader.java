package com.kvitka.recipeproject.bootstrap;

import com.kvitka.recipeproject.domain.*;
import com.kvitka.recipeproject.services.CategoryService;
import com.kvitka.recipeproject.services.RecipeService;
import com.kvitka.recipeproject.services.UnitOfMeasureService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final CategoryService<Category, Long> categoryService;
    private final RecipeService<Recipe, Long> recipeService;
    private final UnitOfMeasureService<UnitOfMeasure, Long> unitOfMeasureService;

    public DataLoader(CategoryService categoryService, RecipeService<Recipe, Long> recipeService,
                      UnitOfMeasureService<UnitOfMeasure, Long> unitOfMeasureService) {
        this.categoryService = categoryService;
        this.recipeService = recipeService;
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Recipe> recipes = new ArrayList<>(2);

        Optional<UnitOfMeasure> tableSpoon = unitOfMeasureService.findByDescription("Tablespoon");
        System.out.println("unitOfMeasureService.findByDescription(\"Tablespoon\"): ");


        Category category1 = new Category();
        category1.setDescription("Mexican");

        categoryService.save(category1);

        categoryService.findAll().forEach( cat -> System.out.println("category: " + cat.getDescription()));

        Notes notes = new Notes();
        notes.setRecipeNotes("How To Store Guacamole So It Stays Green\n" +
                "Guacamole is best eaten right after it's made. Like apples, avocados start to oxidize and turn brown" +
                " once they've been cut. That said, the acid in the lime juice you add to guacamole can help slow " +
                "down that process. And if you store the guacamole properly, you can easily make it a few hours ahead" +
                " if you are preparing for a party.\n" +
                "\n" +
                "The trick to keeping guacamole green is to make sure air doesn't touch it! Transfer it to a " +
                "container, cover with plastic wrap, and press down on the plastic wrap to squeeze out any air " +
                "pockets. Make sure any exposed surface of the guacamole is touching the plastic wrap, not air. This " +
                "will keep the amount of browning to a minimum.\n" +
                "\n" +
                "You can store the guacamole in the fridge this way for up to three days. If the guacamole develops " +
                "discoloration, you can either scrape off the brown parts and discard, or stir into the rest of the " +
                "guacamole before serving.");

        Recipe recipe1 = new Recipe();
        recipe1.setDescription("Guacamole! Did you know that over 2 billion pounds of avocados are consumed each year " +
                "in the U.S.? (Google it.) That's over 7 pounds per person. I'm guessing that most of those avocados go " +
                "into what has become America's favorite dip: guacamole.");
        recipe1.setCategories(Set.of(category1));
        recipe1.setCookTime(10);
        recipe1.setDifficulty(Difficulty.EASY);
        recipe1.setDirections("Cut the avocados, Mash the avocado flesh, Add the remaining ingredients to taste, Serve immediately");
        recipe1.setNotes(notes);

        recipeService.save(recipe1);

        recipeService.findAll().forEach( rec -> System.out.println("recipe: " + rec.getDescription()));

        recipes.add(recipe1);



        Notes notes2 = new Notes();
        notes2.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled" +
                " jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot" +
                " pan on the stove comes wafting through the house.\n" +
                "\n" +
                "Today's tacos are more purposeful a deliberate meal instead of a secretive midnight snack!\n" +
                "\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and " +
                "sweet orange juice while the grill is heating. You can also use this time to prepare the taco " +
                "toppings.\n" +
                "\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the " +
                "tacos and dig in. The whole meal comes together in about 30 minutes!");

        Recipe recipe2 = new Recipe();
        recipe2.setDescription("Spicy grilled chicken tacos! Quick marinade, then grill. Ready in about 30 minutes. " +
                "Great for a quick weeknight dinner, backyard cookouts, and tailgate parties.");
        recipe2.setCategories(Set.of(category1));
        recipe2.setCookTime(30);
        recipe2.setDifficulty(Difficulty.MODERATE);
        recipe2.setDirections("Prepare the grill, Make the marinade and coat the chicken");
        recipe2.setNotes(notes2);

        recipeService.save(recipe2);

        recipeService.findAll().forEach( rec -> System.out.println("recipe: " + rec.getDescription()));

        recipes.add(recipe2);
    }
}
