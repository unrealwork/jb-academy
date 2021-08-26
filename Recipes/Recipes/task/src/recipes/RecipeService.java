package recipes;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeService implements MapRecipeService {
    private final Map<Integer, Recipe> storage = new HashMap<>();

    @Override
    public synchronized AdditionResult add(Recipe recipe) {
        final int id = storage.size();
        storage.put(id, recipe);
        return AdditionResult.of(id);
    }

    @Override
    public synchronized Recipe findById(final int id) {
        return storage.get(id);
    }
}
