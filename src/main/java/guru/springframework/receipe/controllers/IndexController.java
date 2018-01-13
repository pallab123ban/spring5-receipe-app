package guru.springframework.receipe.controllers;

import guru.springframework.receipe.domain.Category;
import guru.springframework.receipe.domain.UnitOfMeasure;
import guru.springframework.receipe.repositories.CategoryRepository;
import guru.springframework.receipe.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * This is index controller class.
 * @author PALLAB
 */
@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage() {

        Optional<Category> optionalCategory = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> optionalUnitOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Category id is: " + optionalCategory.get().getId());
        System.out.println("UnitOfMeasure id is: " + optionalUnitOfMeasure.get().getId());


        return "index";
    }
}
