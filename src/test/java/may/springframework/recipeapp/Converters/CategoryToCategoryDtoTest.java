package may.springframework.recipeapp.Converters;

import may.springframework.recipeapp.DTO.CategoryDto;
import may.springframework.recipeapp.model.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryToCategoryDtoTest {

    private final Long ID = new Long(1L);
    private final String DESCRIPTION = "description";
    CategoryToCategoryDto converter;

    @Before
    public void setUp() throws Exception {
        converter = new CategoryToCategoryDto();
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Category()));
    }

    @Test
    public void convert() {
        //given
        Category category = new Category();
        category.setId(ID);
        category.setDescription(DESCRIPTION);

        //when
        CategoryDto categoryDto = converter.convert(category);

        //then
        assertEquals(ID, categoryDto.getId());
        assertEquals(DESCRIPTION, categoryDto.getDescription());
    }
}