package may.springframework.recipeapp.Converters;

import may.springframework.recipeapp.DTO.CategoryDto;
import may.springframework.recipeapp.DTO.IngredientDto;
import may.springframework.recipeapp.DTO.NotesDto;
import may.springframework.recipeapp.DTO.RecipeDto;
import may.springframework.recipeapp.model.Difficulty;
import may.springframework.recipeapp.model.Recipe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeDtoToRecipeTest {

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

    RecipeDtoToRecipe converter;

    @Before
    public void setUp() throws Exception {
        converter = new RecipeDtoToRecipe(new NotesDtoToNotes(),
                new IngredientDtoToIngredient(new UnitOfMeasureDtoToUnitOfMeasure()), new CategoryDtoToCategory());
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new RecipeDto()));
    }

    @Test
    public void convert() {
        //given
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setId(RECIPE_ID);
        recipeDto.setCookTime(COOK_TIME);
        recipeDto.setPrepTime(PREP_TIME);
        recipeDto.setDescription(DESCRIPTION);
        recipeDto.setDifficulty(DIFFICULTY);
        recipeDto.setDirections(DIRECTIONS);
        recipeDto.setServings(SERVINGS);
        recipeDto.setSource(SOURCE);
        recipeDto.setUrl(URL);

        IngredientDto ingredient1 = new IngredientDto();
        ingredient1.setId(INGRED_ID1);
        recipeDto.getIngredients().add(ingredient1);
        IngredientDto ingredient2 = new IngredientDto();
        ingredient2.setId(INGRED_ID2);
        recipeDto.getIngredients().add(ingredient2);

        CategoryDto cat1 = new CategoryDto();
        cat1.setId(CAT_ID1);
        recipeDto.getCategories().add(cat1);
        CategoryDto cat2 = new CategoryDto();
        cat2.setId(CAT_ID2);
        recipeDto.getCategories().add(cat2);

        NotesDto notes = new NotesDto();
        notes.setId(NOTES_ID);
        recipeDto.setNotes(notes);

        //when
        Recipe recipe = converter.convert(recipeDto);

        //then
        assertNotNull(recipe);
        assertEquals(RECIPE_ID, recipe.getId());
        assertEquals(COOK_TIME, recipe.getCookTime());
        assertEquals(PREP_TIME, recipe.getPrepTime());
        assertEquals(DESCRIPTION, recipe.getDescription());
        assertEquals(DIFFICULTY, recipe.getDifficulty());
        assertEquals(DIRECTIONS, recipe.getDirections());
        assertEquals(SERVINGS, recipe.getServings());
        assertEquals(SOURCE, recipe.getSource());
        assertEquals(URL, recipe.getUrl());
        assertEquals(NOTES_ID, recipe.getNotes().getId());
        assertEquals(2, recipe.getCategories().size());
        assertEquals(2, recipe.getIngredients().size());
    }
}