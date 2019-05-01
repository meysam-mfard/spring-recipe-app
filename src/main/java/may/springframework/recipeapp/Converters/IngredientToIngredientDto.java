package may.springframework.recipeapp.Converters;

import lombok.Synchronized;
import may.springframework.recipeapp.DTO.IngredientDto;
import may.springframework.recipeapp.model.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientDto implements Converter<Ingredient, IngredientDto> {

    private final UnitOfMeasureToUnitOfMeasureDto unitOfMeasureConverter;

    public IngredientToIngredientDto(UnitOfMeasureToUnitOfMeasureDto unitOfMeasureConverter) {
        this.unitOfMeasureConverter = unitOfMeasureConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public IngredientDto convert(Ingredient source) {
        if (source == null)
            return null;

        final IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setId(source.getId());
        if (source.getRecipe() != null)
            ingredientDto.setRecipeId(source.getRecipe().getId());
        ingredientDto.setAmount(source.getAmount());
        ingredientDto.setDescription(source.getDescription());
        ingredientDto.setUom(unitOfMeasureConverter.convert(source.getUom()));
        return ingredientDto;
    }
}
