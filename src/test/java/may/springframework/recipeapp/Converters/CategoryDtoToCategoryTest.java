package may.springframework.recipeapp.Converters;

import may.springframework.recipeapp.DTO.CategoryDto;
import may.springframework.recipeapp.model.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryDtoToCategoryTest {

    private final Long ID = new Long(1L);
    private final String DESCRIPTION = "description";
    CategoryDtoToCategory converter;


    @Before
    public void setUp() throws Exception {
        converter = new CategoryDtoToCategory();
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new CategoryDto()));
    }

    @Test
    public void convert() {
        //given
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(ID);
        categoryDto.setDescription(DESCRIPTION);

        //when
        Category category = converter.convert(categoryDto);

        //then
        assertEquals(ID, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }
}