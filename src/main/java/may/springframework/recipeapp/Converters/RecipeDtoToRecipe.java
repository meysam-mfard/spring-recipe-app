package may.springframework.recipeapp.Converters;

import lombok.Synchronized;
import may.springframework.recipeapp.DTO.RecipeDto;
import may.springframework.recipeapp.model.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeDtoToRecipe implements Converter<RecipeDto, Recipe> {

    private final NotesDtoToNotes notesConverter;
    private final IngredientDtoToIngredient ingredientConverter;
    private final CategoryDtoToCategory categoryConverter;

    public RecipeDtoToRecipe(NotesDtoToNotes notesConverter, IngredientDtoToIngredient ingredientConverter,
                             CategoryDtoToCategory categoryConverter) {
        this.notesConverter = notesConverter;
        this.ingredientConverter = ingredientConverter;
        this.categoryConverter = categoryConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeDto source) {
        if (source == null)
            return null;

        final Recipe recipe = new Recipe();
        recipe.setId(source.getId());
        recipe.setDescription(source.getDescription());
        recipe.setPrepTime(source.getPrepTime());
        recipe.setCookTime(source.getCookTime());
        recipe.setServings(source.getServings());
        recipe.setSource(source.getSource());
        recipe.setUrl(source.getUrl());
        recipe.setDirections(source.getDirections());
        recipe.setDifficulty(source.getDifficulty());
        recipe.setNotes(notesConverter.convert(source.getNotes()));

        if (source.getIngredients() != null && source.getIngredients().size()>0) {
            source.getIngredients().forEach(ingredientDto ->
                    recipe.getIngredients().add(ingredientConverter.convert(ingredientDto)));
        }

        if (source.getCategories() != null && source.getCategories().size()>0) {
            source.getCategories().forEach(categoryDto ->
                    recipe.getCategories().add(categoryConverter.convert(categoryDto)));
        }

        return recipe;
    }
}
