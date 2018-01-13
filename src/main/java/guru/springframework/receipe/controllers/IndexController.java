package guru.springframework.receipe.controllers;

import guru.springframework.receipe.domain.Category;
import guru.springframework.receipe.domain.UnitOfMeasure;
import guru.springframework.receipe.repositories.CategoryRepository;
import guru.springframework.receipe.repositories.UnitOfMeasureRepository;
import guru.springframework.receipe.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * This is index controller class.
 * @author PALLAB
 */
@Controller
public class IndexController {

   @Autowired
    RecipeService recipeService;

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model) {

        model.addAttribute("recipes", recipeService.getAllRecipe());

        return "index";
    }
}
