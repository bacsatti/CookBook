package hu.bme.homework.cookbook.dbservice.controller;

import hu.bme.homework.cookbook.dbservice.persistance.Recipe;
import hu.bme.homework.cookbook.dbservice.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/")
    public List<Recipe> getAll(){
        return recipeService.getAllRecipes();
    }

    @GetMapping("/{id}")
    public Recipe getRecipeById(@PathVariable("id") Long id){
        return recipeService.getRecipeById(id);
    }

    @PostMapping("/add")
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }
}
