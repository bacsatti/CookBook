package hu.bme.homework.cookbook.dbservice.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Long> {
    Recipe getRecipeByTitle(String title);
    void saveRecipe(Recipe recipe);
}
