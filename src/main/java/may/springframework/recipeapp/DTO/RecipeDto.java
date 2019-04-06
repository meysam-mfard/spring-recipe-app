package may.springframework.recipeapp.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import may.springframework.recipeapp.model.Difficulty;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeDto {
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Difficulty difficulty;
    private NotesDto notes;
    private Set<IngredientDto> ingredients = new HashSet<>();
    private Set<CategoryDto> categories = new HashSet<>();
}
