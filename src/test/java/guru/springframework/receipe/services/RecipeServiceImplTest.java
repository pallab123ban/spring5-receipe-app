package guru.springframework.receipe.services;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import guru.springframework.receipe.domain.Recipe;
import guru.springframework.receipe.repositories.RecipeRepository;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RecipeServiceImplTest {

  @InjectMocks
  private RecipeServiceImpl subject;

  @Mock
  RecipeRepository mockRecipeRepository;

  private Recipe recipe;

  private Set<Recipe> recipeList;

  @BeforeMethod
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    recipe = new Recipe();
    recipeList = new HashSet<>();
    recipeList.add(recipe);
    doReturn(recipeList).when(mockRecipeRepository).findAll();
  }

  @Test
  public void getRecipeByIdTest() throws Exception {
    Recipe recipe = new Recipe();
    recipe.setId(1L);
    Optional<Recipe> recipeOptional = Optional.of(recipe);

    when(mockRecipeRepository.findById(anyLong())).thenReturn(recipeOptional);

    Recipe recipeReturned = subject.getRecipeById(1L);

    assertNotNull("Null recipe returned", recipeReturned);
    verify(mockRecipeRepository, times(1)).findById(anyLong());
    verify(mockRecipeRepository, never()).findAll();
  }

  @Test
  public void testGetAllRecipe() throws Exception {
    assertEquals(subject.getAllRecipe(), recipeList, "Recipe List : ");
    verify(mockRecipeRepository, times(1)).findAll();
  }
}