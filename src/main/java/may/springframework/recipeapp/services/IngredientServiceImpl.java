package may.springframework.recipeapp.services;

import lombok.extern.slf4j.Slf4j;
import may.springframework.recipeapp.Converters.IngredientToIngredientDto;
import may.springframework.recipeapp.DTO.IngredientDto;
import may.springframework.recipeapp.Repositories.RecipeRepository;
import may.springframework.recipeapp.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {

    private final RecipeRepository recipeRepository;
    private final IngredientToIngredientDto ingredientToIngredientDto;

    public IngredientServiceImpl(RecipeRepository recipeRepository, IngredientToIngredientDto ingredientToIngredientDto) {
        this.recipeRepository = recipeRepository;
        this.ingredientToIngredientDto = ingredientToIngredientDto;
    }

    @Override
    public IngredientDto findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {

        Optional<Recipe> recipeOptional =  recipeRepository.findById(recipeId);

        if (!recipeOptional.isPresent()) {
            //todo impl error handling
            log.error("Recipe not found. Id: "+ recipeId);
        }

        Recipe recipe =  recipeOptional.get();

        Optional<IngredientDto> ingredientDtoOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredient -> ingredientToIngredientDto.convert(ingredient))
                .findFirst();

        if (!ingredientDtoOptional.isPresent()) {
            //todo impl error handling
            log.error("Ingredient not found. Id: "+ ingredientId);
        }

        return ingredientDtoOptional.get();
    }
}
