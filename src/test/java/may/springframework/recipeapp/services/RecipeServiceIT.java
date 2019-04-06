package may.springframework.recipeapp.services;

import may.springframework.recipeapp.Converters.RecipeDtoToRecipe;
import may.springframework.recipeapp.Converters.RecipeToRecipeDto;
import may.springframework.recipeapp.DTO.RecipeDto;
import may.springframework.recipeapp.Repositories.RecipeRepository;
import may.springframework.recipeapp.model.Recipe;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeServiceIT {

    public static final String NEW_DESCRIPTION = "New Description";

    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeDtoToRecipe recipeDtoToRecipe;

    @Autowired
    RecipeToRecipeDto recipeToRecipeDto;


    @Transactional
    @Test
    public void saveRecipeDto() {
        //given
        Iterable<Recipe> recipes = recipeRepository.findAll();
        Recipe testRecipe = recipes.iterator().next();
        RecipeDto testRecipeDto = recipeToRecipeDto.convert(testRecipe);
        System.out.println(testRecipe.getDescription());

        //when
        testRecipeDto.setDescription(NEW_DESCRIPTION);
        RecipeDto savedRecipeDto = recipeService.saveRecipeDto(testRecipeDto);

        //then
        assertEquals(NEW_DESCRIPTION, savedRecipeDto.getDescription());
        assertEquals(testRecipe.getId(), savedRecipeDto.getId());
        assertEquals(testRecipe.getCategories().size(), savedRecipeDto.getCategories().size());
        assertEquals(testRecipe.getIngredients().size(), savedRecipeDto.getIngredients().size());

        Long id = testRecipe.getId();
        assertEquals(NEW_DESCRIPTION, recipeService.findById(id).getDescription());
    }
}