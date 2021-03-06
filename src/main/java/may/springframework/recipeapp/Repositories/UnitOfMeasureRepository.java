package may.springframework.recipeapp.Repositories;

import may.springframework.recipeapp.model.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long>{

    //Query method
    Optional<UnitOfMeasure> findByDescription(String description);
}
