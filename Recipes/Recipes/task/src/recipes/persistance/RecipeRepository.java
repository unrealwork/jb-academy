package recipes.persistance;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
    List<Recipe> findAllByCategory(final String category);
    List<Recipe> findAllByName(final String name);
}
