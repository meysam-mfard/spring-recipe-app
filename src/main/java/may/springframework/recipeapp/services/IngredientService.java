package may.springframework.recipeapp.services;

import may.springframework.recipeapp.DTO.IngredientDto;

public interface IngredientService {

    IngredientDto findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
}
