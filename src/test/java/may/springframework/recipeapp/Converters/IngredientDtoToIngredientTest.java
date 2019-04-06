package may.springframework.recipeapp.Converters;

import may.springframework.recipeapp.DTO.IngredientDto;
import may.springframework.recipeapp.DTO.UnitOfMeasureDto;
import may.springframework.recipeapp.model.Ingredient;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class IngredientDtoToIngredientTest {

    private final Long ID = new Long(1L);
    private final String DESCRIPTION = "description";
    private final BigDecimal AMOUNT = new BigDecimal("1");
    private final Long UOM_ID = new Long(2L);

    IngredientDtoToIngredient converter;

    @Before
    public void setUp() throws Exception {
        converter = new IngredientDtoToIngredient(new UnitOfMeasureDtoToUnitOfMeasure());
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new IngredientDto()));
    }

    @Test
    public void convert() {
        //given
        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setId(ID);
        ingredientDto.setDescription(DESCRIPTION);
        ingredientDto.setAmount(AMOUNT);
        UnitOfMeasureDto unitOfMeasureDto = new UnitOfMeasureDto();
        unitOfMeasureDto.setId(UOM_ID);
        ingredientDto.setUnitOfMeasure(unitOfMeasureDto);

        //when
        Ingredient ingredient = converter.convert(ingredientDto);

        //then
        assertEquals(ID, ingredient.getId());
        assertEquals(DESCRIPTION, ingredient.getDescription());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertEquals(UOM_ID, ingredient.getUom().getId());
    }

    @Test
    public void convertWithNullUOM() throws Exception {
        //given
        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setId(ID);
        ingredientDto.setDescription(DESCRIPTION);
        ingredientDto.setAmount(AMOUNT);

        //when
        Ingredient ingredient = converter.convert(ingredientDto);

        //then
        assertNull(ingredient.getUom());
        assertEquals(ID, ingredient.getId());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertEquals(DESCRIPTION, ingredient.getDescription());

    }
}