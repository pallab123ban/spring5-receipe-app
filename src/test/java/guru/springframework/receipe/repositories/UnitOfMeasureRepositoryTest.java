package guru.springframework.receipe.repositories;

import static org.junit.Assert.*;

import guru.springframework.receipe.domain.UnitOfMeasure;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author PALLAB
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryTest {

  @Autowired
  UnitOfMeasureRepository unitOfMeasureRepository;

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void findByDescriptionTeaspoon() {

    Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
    assertEquals("Teaspoon", uomOptional.get().getDescription());
  }

  @Test
  public void findByDescriptionCup() {

    Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Cup");
    assertEquals("Cup", uomOptional.get().getDescription());
  }
}