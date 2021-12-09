package hu.bme.homework.cookbook.dbservice.service;

import hu.bme.homework.cookbook.dbservice.dto.RecipeCreateDto;
import hu.bme.homework.cookbook.dbservice.dto.RecipeDto;
import hu.bme.homework.cookbook.dbservice.mapper.RecipeMapper;
import hu.bme.homework.cookbook.dbservice.persistance.Recipe;
import hu.bme.homework.cookbook.dbservice.persistance.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeMapper recipeMapper;

    public Recipe addRecipe(RecipeCreateDto createDto) {
        Optional<Recipe> recipe = recipeMapper.recipeCreateDtoToEntity(createDto);
        if (recipe.isEmpty()) return null;
        return recipeRepository.save(recipe.get());
    }

    public RecipeDto getRecipeById(Long id) {
        Recipe recipe = getRecipeEntityById(id);
        return recipeMapper.recipeEntityToDto(recipe);
    }

    public List<RecipeDto> getAllRecipes() {
        List<RecipeDto> recipeDtos = recipeRepository.findAll()
                .stream()
                .map(recipe -> recipeMapper.recipeEntityToDto(recipe))
                .collect(Collectors.toList());
        return recipeDtos;
    }

    public Recipe getRecipeEntityById(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No such recipe with id ." + id));
    }
}
