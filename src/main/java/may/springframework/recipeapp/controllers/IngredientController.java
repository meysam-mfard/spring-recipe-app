package may.springframework.recipeapp.controllers;

import lombok.extern.slf4j.Slf4j;
import may.springframework.recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
public class IngredientController {

    private final RecipeService recipeService;

    public IngredientController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/{id}/ingredients")
    public String getIngredients(@PathVariable String id, Model model) {

        model.addAttribute("recipe", recipeService.findRecipeDtoById(Long.valueOf(id)));

        return "recipe/ingredient/list";
    }
}
