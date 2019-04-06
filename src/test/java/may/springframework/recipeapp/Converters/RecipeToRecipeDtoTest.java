package may.springframework.recipeapp.Converters;

import may.springframework.recipeapp.DTO.RecipeDto;
import may.springframework.recipeapp.model.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeToRecipeDtoTest {

    private final Long RECIPE_ID = 1L;
    private final Integer COOK_TIME = Integer.valueOf("5");
    private final Integer PREP_TIME = Integer.valueOf("7");
    private final String DESCRIPTION = "My Recipe";
    private final String DIRECTIONS = "Directions";
    private final Difficulty DIFFICULTY = Difficulty.EASY;
    private final Integer SERVINGS = Integer.valueOf("3");
    private final String SOURCE = "Source";
    private final String URL = "Some URL";
    private final Long CAT_ID1 = 1L;
    private final Long CAT_ID2 = 2L;
    private final Long INGRED_ID1 = 3L;
    private final Long INGRED_ID2 = 4L;
    private final Long NOTES_ID = 9L;

    RecipeToRecipeDto converter;

    @Before
    public void setUp() throws Exception {
        converter = new RecipeToRecipeDto(new IngredientToIngredientDto(new UnitOfMeasureToUnitOfMeasureDto()),
                new NotesToNotesDto(), new CategoryToCategoryDto());
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Recipe()));
    }

    @Test
    public void convert() {
        //given
        Recipe recipe = new Recipe();
        recipe.setId(RECIPE_ID);
        recipe.setCookTime(COOK_TIME);
        recipe.setPrepTime(PREP_TIME);
        recipe.setDescription(DESCRIPTION);
        recipe.setDifficulty(DIFFICULTY);
        recipe.setDirections(DIRECTIONS);
        recipe.setServings(SERVINGS);
        recipe.setSource(SOURCE);
        recipe.setUrl(URL);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(INGRED_ID1);
        recipe.addIngredient(ingredient1);
        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(INGRED_ID2);
        recipe.addIngredient(ingredient2);

        Category cat1 = new Category();
        cat1.setId(CAT_ID1);
        recipe.getCategories().add(cat1);
        Category cat2 = new Category();
        cat2.setId(CAT_ID2);
        recipe.getCategories().add(cat2);

        Notes notes = new Notes();
        notes.setId(NOTES_ID);
        recipe.setNotes(notes);


        //when
        RecipeDto recipeDto = converter.convert(recipe);

        //then
        assertNotNull(recipeDto);
        assertEquals(RECIPE_ID, recipeDto.getId());
        assertEquals(COOK_TIME, recipeDto.getCookTime());
        assertEquals(PREP_TIME, recipeDto.getPrepTime());
        assertEquals(DESCRIPTION, recipeDto.getDescription());
        assertEquals(DIFFICULTY, recipeDto.getDifficulty());
        assertEquals(DIRECTIONS, recipeDto.getDirections());
        assertEquals(SERVINGS, recipeDto.getServings());
        assertEquals(SOURCE, recipeDto.getSource());
        assertEquals(URL, recipeDto.getUrl());
        assertEquals(NOTES_ID, recipeDto.getNotes().getId());
        assertEquals(2, recipeDto.getCategories().size());
        assertEquals(2, recipeDto.getIngredients().size());

    }
}