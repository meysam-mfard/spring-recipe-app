package may.springframework.recipeapp.services;

import may.springframework.recipeapp.Converters.IngredientDtoToIngredient;
import may.springframework.recipeapp.Converters.IngredientToIngredientDto;
import may.springframework.recipeapp.Converters.UnitOfMeasureDtoToUnitOfMeasure;
import may.springframework.recipeapp.Converters.UnitOfMeasureToUnitOfMeasureDto;
import may.springframework.recipeapp.DTO.IngredientDto;
import may.springframework.recipeapp.Repositories.RecipeRepository;
import may.springframework.recipeapp.Repositories.UnitOfMeasureRepository;
import may.springframework.recipeapp.model.Ingredient;
import may.springframework.recipeapp.model.Recipe;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class IngredientServiceImplTest {

    IngredientService ingredientService;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;

    private final IngredientToIngredientDto ingredientToIngredientDto;
    private final IngredientDtoToIngredient ingredientDtoToIngredient;

    public IngredientServiceImplTest() {
        ingredientToIngredientDto = new IngredientToIngredientDto(new UnitOfMeasureToUnitOfMeasureDto());
        ingredientDtoToIngredient = new IngredientDtoToIngredient(new UnitOfMeasureDtoToUnitOfMeasure());
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        ingredientService = new IngredientServiceImpl(recipeRepository, ingredientToIngredientDto, ingredientDtoToIngredient, unitOfMeasureRepository);
    }

    @Test
    public void findByRecipeIdAndIngredientId() {

        Recipe recipe = new Recipe();
        recipe.setId(1L);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(1L);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(2L);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setId(3L);

        recipe.addIngredient(ingredient1);
        recipe.addIngredient(ingredient2);
        recipe.addIngredient(ingredient3);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        IngredientDto ingredientDto = ingredientService.findByRecipeIdAndIngredientId(1L, 3L);

        assertEquals(Long.valueOf(3L), ingredientDto.getId());
        assertEquals(Long.valueOf(1L), ingredientDto.getRecipeId());
        verify(recipeRepository, times(1)).findById(anyLong());
    }
}