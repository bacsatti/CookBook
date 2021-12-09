package hu.bme.homework.cookbook.dbservice.service;

import hu.bme.homework.cookbook.dbservice.persistance.Recipe;
import hu.bme.homework.cookbook.dbservice.persistance.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public Recipe addRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id).orElseThrow(() -> new RuntimeException("No such recipe with id ." + id));
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

}
