package may.springframework.recipeapp.controllers;

import may.springframework.recipeapp.DTO.RecipeDto;
import may.springframework.recipeapp.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class IngredientControllerTest {

    @Mock
    RecipeService recipeService;

    IngredientController ingredientController;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        ingredientController = new IngredientController(recipeService);

        mockMvc = MockMvcBuilders.standaloneSetup(ingredientController).build();
    }

    @Test
    public void getIngredients() throws Exception {

        //given
        RecipeDto recipeDto = new RecipeDto();
        when(recipeService.findRecipeDtoById(anyLong())).thenReturn(recipeDto);

        //when
        mockMvc.perform(get("/recipe/1/ingredients"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredient/list"))
                .andExpect(model().attributeExists("recipe"));

        //then
        verify(recipeService, times(1)).findRecipeDtoById(anyLong());
    }
}