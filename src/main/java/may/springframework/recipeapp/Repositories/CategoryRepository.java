package may.springframework.recipeapp.Repositories;

import may.springframework.recipeapp.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
