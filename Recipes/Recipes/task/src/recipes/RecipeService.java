package recipes;

import org.springframework.stereotype.Service;

@Service
public class RecipeService {
    private Recipe storedRecipe = null;

    public synchronized void set(Recipe recipe) {
        storedRecipe = recipe;
    }

    public synchronized Recipe get() {
        return storedRecipe;
    }
}
