package hu.bme.homework.cookbook.dbservice.mapper;

import hu.bme.homework.cookbook.dbservice.dto.RecipeCreateDto;
import hu.bme.homework.cookbook.dbservice.dto.RecipeDto;
import hu.bme.homework.cookbook.dbservice.persistance.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecipeMapper {

    @Autowired
    private CommentMapper commentMapper;

    public RecipeDto recipeEntityToDto(Recipe recipe) {
        if (recipe == null) return null;

        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setId(recipe.getId());
        recipeDto.setTitle(recipe.getTitle());
        recipeDto.setProcess(recipe.getProcess());
        recipeDto.setIngredients(recipe.getIngredients());
        recipeDto.setComments(recipe.getComments().stream().map(comment -> commentMapper.commentEntityToDto(comment)).collect(Collectors.toList()));
        return recipeDto;
    }

    public Optional<Recipe> recipeCreateDtoToEntity(RecipeCreateDto recipeCreateDto) {
        if (recipeCreateDto == null) return Optional.empty();

        Recipe recipe = new Recipe();
        recipe.setTitle(recipeCreateDto.getTitle());
        recipe.setProcess(recipeCreateDto.getProcess());
        recipe.setIngredients(recipeCreateDto.getIngredients());
        return Optional.of(recipe);
    }

}
