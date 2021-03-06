package may.springframework.recipeapp.Repositories;

import may.springframework.recipeapp.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    //Query method
    Optional<Category> findByDescription(String description);
}
