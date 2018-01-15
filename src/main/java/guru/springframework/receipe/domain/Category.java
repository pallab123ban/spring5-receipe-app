package guru.springframework.receipe.domain;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * This is the category entity class
 *
 * @author PALLAB
 */
@Data
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String description;

  @ManyToMany(mappedBy = "categories")
  private Set<Recipe> recipes;

}
