package hu.bme.homework.cookbook.dbservice.controller;

import hu.bme.homework.cookbook.dbservice.dto.RecipeCreateDto;
import hu.bme.homework.cookbook.dbservice.dto.RecipeDto;
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
    public List<RecipeDto> getAll(){
        return recipeService.getAllRecipes();
    }

    @GetMapping("/{id}")
    public RecipeDto getRecipeById(@PathVariable("id") Long id){
        return recipeService.getRecipeById(id);
    }

    @PostMapping("/add")
    public Recipe addRecipe(@RequestBody RecipeCreateDto recipe) {
        return recipeService.addRecipe(recipe);
    }
}
