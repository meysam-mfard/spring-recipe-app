package may.springframework.recipeapp.services;

import may.springframework.recipeapp.DTO.RecipeDto;
import may.springframework.recipeapp.model.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(long l);

    RecipeDto saveRecipeDto(RecipeDto recipeDto);
}
