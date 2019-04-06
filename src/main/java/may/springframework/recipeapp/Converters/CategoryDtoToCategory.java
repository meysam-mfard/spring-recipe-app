package may.springframework.recipeapp.Converters;

import lombok.Synchronized;
import may.springframework.recipeapp.DTO.CategoryDto;
import may.springframework.recipeapp.model.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryDtoToCategory implements Converter<CategoryDto, Category> {

    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryDto source) {
        if (source == null)
            return null;

        final Category category = new Category();
        category.setId(source.getId());
        category.setDescription(category.getDescription());
        return category;
    }
}
