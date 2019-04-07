package may.springframework.recipeapp.Converters;

import may.springframework.recipeapp.DTO.IngredientDto;
import may.springframework.recipeapp.model.Ingredient;
import may.springframework.recipeapp.model.Recipe;
import may.springframework.recipeapp.model.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class IngredientToIngredientDtoTest {

    private final Long ID = new Long(1L);
    private final String DESCRIPTION = "description";
    private final BigDecimal AMOUNT = new BigDecimal("1");
    private final Long UOM_ID = new Long(2L);
    private final Recipe RECIPE = new Recipe();

    private IngredientToIngredientDto converter;

    @Before
    public void setUp() throws Exception {
        converter = new IngredientToIngredientDto(new UnitOfMeasureToUnitOfMeasureDto());
    }

    @Test
    public void testNullConvert() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Ingredient()));
    }

    @Test
    public void convert() {
        //given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID);
        ingredient.setRecipe(RECIPE);
        ingredient.setAmount(AMOUNT);
        ingredient.setDescription(DESCRIPTION);
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(UOM_ID);
        ingredient.setUom(uom);

        //when
        IngredientDto ingredientDto = converter.convert(ingredient);

        //then
        assertEquals(ID, ingredientDto.getId());
        assertEquals(DESCRIPTION, ingredientDto.getDescription());
        assertEquals(AMOUNT, ingredientDto.getAmount());
        assertEquals(UOM_ID, ingredientDto.getUom().getId());
    }

    @Test
    public void convertWithNullUOM() {
        //given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID);
        ingredient.setRecipe(RECIPE);
        ingredient.setAmount(AMOUNT);
        ingredient.setDescription(DESCRIPTION);

        //when
        IngredientDto ingredientDto = converter.convert(ingredient);

        //then
        assertEquals(ID, ingredientDto.getId());
        assertEquals(DESCRIPTION, ingredientDto.getDescription());
        assertEquals(AMOUNT, ingredientDto.getAmount());
        assertNull(ingredientDto.getUom());
    }
}