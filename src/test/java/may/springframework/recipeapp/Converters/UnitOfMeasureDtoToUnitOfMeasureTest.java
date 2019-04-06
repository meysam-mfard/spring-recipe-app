package may.springframework.recipeapp.Converters;

import may.springframework.recipeapp.DTO.UnitOfMeasureDto;
import may.springframework.recipeapp.model.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureDtoToUnitOfMeasureTest {

    private final Long ID = new Long(1L);
    private final String DESCRIPTION = "description";
    private UnitOfMeasureDtoToUnitOfMeasure converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureDtoToUnitOfMeasure();
    }

    @Test
    public void testNullParamter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new UnitOfMeasureDto()));
    }

    @Test
    public void convert() {
        //given
        UnitOfMeasureDto unitOfMeasureDto = new UnitOfMeasureDto();
        unitOfMeasureDto.setId(ID);
        unitOfMeasureDto.setDescription(DESCRIPTION);

        //when
        UnitOfMeasure uom = converter.convert(unitOfMeasureDto);

        //then
        assertNotNull(uom);
        assertEquals(ID, uom.getId());
        assertEquals(DESCRIPTION, uom.getDescription());
    }
}