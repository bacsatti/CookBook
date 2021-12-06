package hu.bme.homework.cookbook.dbservice.controller;

import hu.bme.homework.cookbook.dbservice.persistance.Recipe;
import hu.bme.homework.cookbook.dbservice.persistance.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Repository
@EnableJpaRepositories
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping("/")
    public List<Recipe> getAll(){

        return recipeRepository.findAll();

    }
    @GetMapping("/{title}")
    @ResponseBody
    public Recipe getOne(@PathVariable("title") String title){

        return recipeRepository.getRecipeByTitle(title);

    }
    @PostMapping(value = "/add", consumes = "MediaType.APPLICATION_JSON_VALUE", produces = "MediaType.APPLICATION_JSON_VALUE")
    public void createRecipe(@RequestBody Recipe recipe) {
        recipeRepository.saveRecipe(recipe);
    }
}
