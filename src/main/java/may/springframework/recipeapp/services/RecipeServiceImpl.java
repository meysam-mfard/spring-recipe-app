package may.springframework.recipeapp.services;

import lombok.extern.slf4j.Slf4j;
import may.springframework.recipeapp.Repositories.RecipeRepository;
import may.springframework.recipeapp.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("I'm in the Recipe Service");

        Set<Recipe> recipes = new HashSet<>();
        //recipeRepository.findAll().forEach(recipe -> recipes.add(recipe));
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);

        return recipes;
    }
}
