package guru.springframework.receipe.domain;

import static org.testng.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CategoryTest {

  private Category category;
  private static final long TEST_ID = 5l;
  private static final String TEST_DESCRIPTION = "TEST";

  @BeforeMethod
  public void setUp() throws Exception {
    category = new Category();
  }


  @Test
  public void testGetId() throws Exception {
    category.setId(TEST_ID);
    assertEquals(category.getId(), TEST_ID, "Category Id : ");
  }

  @Test
  public void testGetDescription() throws Exception {
    category.setDescription(TEST_DESCRIPTION);
    assertEquals(category.getDescription(), TEST_DESCRIPTION, "Category description : ");
  }

  @Test
  public void testGetRecipes() throws Exception {
    Recipe recipe = new Recipe();
    Set<Recipe> recipeList = new HashSet<>();
    recipeList.add(recipe);
    category.setRecipes(recipeList);

    assertEquals(category.getRecipes(), recipeList, "Category Recipe List : ");
  }
}