package may.springframework.recipeapp.Repositories;

import may.springframework.recipeapp.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
