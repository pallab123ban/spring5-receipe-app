package guru.springframework.receipe.controllers;


import guru.springframework.receipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author PALLAB
 */
@Controller
@Slf4j
public class RecipeController {

  @Autowired
  RecipeService recipeService;

  @RequestMapping("/recipe/show/{id}")
  public String getRecipe(@PathVariable String id, Model model){
    model.addAttribute("recipe", recipeService.getRecipeById(new Long(id)));
    return "recipe/show";
  }

}
