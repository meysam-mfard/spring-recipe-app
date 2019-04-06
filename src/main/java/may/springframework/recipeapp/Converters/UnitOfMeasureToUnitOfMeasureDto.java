package may.springframework.recipeapp.Converters;

import lombok.Synchronized;
import may.springframework.recipeapp.DTO.UnitOfMeasureDto;
import may.springframework.recipeapp.model.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureDto implements Converter<UnitOfMeasure, UnitOfMeasureDto> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasureDto convert(UnitOfMeasure source) {
        if (source == null)
            return null;

        final UnitOfMeasureDto unitOfMeasureDto = new UnitOfMeasureDto();
        unitOfMeasureDto.setId(source.getId());
        unitOfMeasureDto.setDescription(source.getDescription());
        return unitOfMeasureDto;
    }
}
