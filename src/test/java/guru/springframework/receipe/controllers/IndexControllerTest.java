package guru.springframework.receipe.controllers;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertNotNull;
import static org.testng.AssertJUnit.assertEquals;

import guru.springframework.receipe.domain.Recipe;
import guru.springframework.receipe.services.RecipeService;
import java.util.HashSet;
import java.util.Set;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author PALLAB
 */
public class IndexControllerTest {

  @InjectMocks
  IndexController subject;

  @Mock
  RecipeService mockRecipeService;

  @Mock
  Model mockModel;


  private Set<Recipe> recipeList;

  private Recipe recipe;

  private static final String INDEX = "index";

  @BeforeMethod
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testGetIndexPage() throws Exception {

    //given
    recipe = new Recipe();
    recipe.setId(3l);
    recipeList = new HashSet<>();
    recipeList.add(recipe);
    recipe = new Recipe();
    recipe.setId(4l);
    recipeList.add(recipe);

    ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

    //when
    when(mockRecipeService.getAllRecipe()).thenReturn(recipeList);

    //then
    assertEquals(subject.getIndexPage(mockModel), INDEX);
    verify(mockRecipeService, times(1)).getAllRecipe();
    //verify(mockModel, times(1)).addAttribute(eq("recipes"), eq(recipeList));
    verify(mockModel, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());

    Set<Recipe> setInController = argumentCaptor.getValue();

    assertEquals(2, setInController.size());
  }
}