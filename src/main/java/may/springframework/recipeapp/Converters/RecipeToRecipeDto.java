package may.springframework.recipeapp.Converters;

import lombok.Synchronized;
import may.springframework.recipeapp.DTO.RecipeDto;
import may.springframework.recipeapp.model.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class RecipeToRecipeDto implements Converter<Recipe, RecipeDto> {

    private final NotesToNotesDto notesConverter;
    private final IngredientToIngredientDto ingredientConverter;
    private final CategoryToCategoryDto categoryConverter;

    public RecipeToRecipeDto(IngredientToIngredientDto ingredientConverter, NotesToNotesDto notesConverter,
                             CategoryToCategoryDto categoryConverter) {
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
        this.categoryConverter = categoryConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public RecipeDto convert(Recipe source) {
        if (source == null)
            return null;

        final RecipeDto recipeDto = new RecipeDto();
        recipeDto.setId(source.getId());
        recipeDto.setDescription(source.getDescription());
        recipeDto.setPrepTime(source.getPrepTime());
        recipeDto.setCookTime(source.getCookTime());
        recipeDto.setServings(source.getServings());
        recipeDto.setSource(source.getSource());
        recipeDto.setUrl(source.getUrl());
        recipeDto.setDirections(source.getDirections());
        recipeDto.setDifficulty(source.getDifficulty());
        recipeDto.setNotes(notesConverter.convert(source.getNotes()));

        if (source.getIngredients() != null && source.getIngredients().size()>0) {
            source.getIngredients().forEach( (ingredient) ->
                    recipeDto.getIngredients().add(ingredientConverter.convert(ingredient)));
        }

        if (source.getCategories() != null && source.getCategories().size()>0) {
            source.getCategories().forEach(category ->
                    recipeDto.getCategories().add(categoryConverter.convert(category)));
        }

        return recipeDto;
    }
}
