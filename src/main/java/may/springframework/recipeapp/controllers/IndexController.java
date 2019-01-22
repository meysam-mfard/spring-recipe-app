package may.springframework.recipeapp.controllers;

import may.springframework.recipeapp.Repositories.CategoryRepository;
import may.springframework.recipeapp.Repositories.UnitOfMeasureRepository;
import may.springframework.recipeapp.model.Category;
import may.springframework.recipeapp.model.UnitOfMeasure;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Category Id     is: " + categoryOptional.get().getId());
        System.out.println("Unit of measure Id is: " + unitOfMeasureOptional.get().getId());

        return "index";
    }
}
