package may.springframework.recipeapp.services;

import may.springframework.recipeapp.DTO.IngredientDto;
import org.springframework.transaction.annotation.Transactional;

public interface IngredientService {

    IngredientDto findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

    @Transactional
    IngredientDto saveIngredientDto(IngredientDto ingredientDto);

    void deleteById(Long recipeId, Long ingredientId);
}
