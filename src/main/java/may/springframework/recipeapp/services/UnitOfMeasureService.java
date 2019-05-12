package may.springframework.recipeapp.services;

import may.springframework.recipeapp.DTO.UnitOfMeasureDto;

import java.util.Set;

public interface UnitOfMeasureService {

    Set<UnitOfMeasureDto> listAllUoms();
}
