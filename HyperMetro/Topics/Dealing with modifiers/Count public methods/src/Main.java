import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class ReflectionUtils {

    public static int countPublicMethods(Class targetClass) {
        int count = 0;
        for (Method m : targetClass.getDeclaredMethods()) {
            if (Modifier.isPublic(m.getModifiers())) {
                count++;
            }
        }
        return count;
    }
}
