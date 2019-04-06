package may.springframework.recipeapp.Converters;

import may.springframework.recipeapp.DTO.UnitOfMeasureDto;
import may.springframework.recipeapp.model.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureToUnitOfMeasureDtoTest {

    private final Long ID = new Long(1L);
    private final String DESCRIPTION = "description";
    private UnitOfMeasureToUnitOfMeasureDto converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureToUnitOfMeasureDto();
    }

    @Test
    public void testNullObjectConvert() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObj() throws Exception {
        assertNotNull(converter.convert(new UnitOfMeasure()));
    }

    @Test
    public void convert() {
        //given
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(ID);
        unitOfMeasure.setDescription(DESCRIPTION);

        //when
        UnitOfMeasureDto unitOfMeasureDto = converter.convert(unitOfMeasure);

        assertEquals(ID, unitOfMeasureDto.getId());
        assertEquals(DESCRIPTION, unitOfMeasureDto.getDescription());
    }
}