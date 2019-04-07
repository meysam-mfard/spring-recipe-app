package may.springframework.recipeapp.services;

import lombok.extern.slf4j.Slf4j;
import may.springframework.recipeapp.Converters.RecipeDtoToRecipe;
import may.springframework.recipeapp.Converters.RecipeToRecipeDto;
import may.springframework.recipeapp.DTO.RecipeDto;
import may.springframework.recipeapp.Repositories.RecipeRepository;
import may.springframework.recipeapp.model.Recipe;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeDtoToRecipe recipeDtoToRecipe;
    private final RecipeToRecipeDto recipeToRecipeDto;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeDtoToRecipe recipeDtoToRecipe,
                             RecipeToRecipeDto recipeToRecipeDto) {
        this.recipeRepository = recipeRepository;
        this.recipeDtoToRecipe = recipeDtoToRecipe;
        this.recipeToRecipeDto = recipeToRecipeDto;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("I'm in the Recipe Service");

        Set<Recipe> recipes = new HashSet<>();
        //recipeRepository.findAll().forEach(recipe -> recipes.add(recipe));
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);

        return recipes;
    }

    @Override
    public Recipe findById(Long l) {
        /*return recipeRepository.findById(l).orElseThrow(() -> {
            throw new RuntimeException("Recipe not found!");});*/
        Optional<Recipe> recipeOptional = recipeRepository.findById(l);

        if (!recipeOptional.isPresent()) {
            throw new RuntimeException("Recipe Not Found!");
        }

        return recipeOptional.get();
    }

    @Override
    @Transactional
    public RecipeDto findRecipeDtoById(Long id) {
        return recipeToRecipeDto.convert(findById(id));
    }

    @Override
    @Transactional
    public RecipeDto saveRecipeDto(RecipeDto recipeDto) {
        Recipe detachedRecipe = recipeDtoToRecipe.convert(recipeDto);
        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        log.debug("Saved RecipeId:" + savedRecipe.getId());
        return recipeToRecipeDto.convert(savedRecipe);
    }

    @Override
    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }
}
