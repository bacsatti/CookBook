package hu.bme.homework.cookbook.dbservice.controller;

import hu.bme.homework.cookbook.dbservice.persistance.Recipe;
import hu.bme.homework.cookbook.dbservice.persistance.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
}
