package may.springframework.recipeapp.controllers;

import may.springframework.recipeapp.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class IndexControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    IndexController indexController;

    @Before
    public void setup()  throws Exception{
        MockitoAnnotations.initMocks(this);

        indexController = new IndexController(recipeService);
    }


    @Test
    public void getIndexPage()  throws Exception{

        assertEquals(indexController.getIndexPage(model), "index");
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), anySet());

    }
}