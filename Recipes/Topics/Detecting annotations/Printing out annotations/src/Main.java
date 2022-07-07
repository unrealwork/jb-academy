import java.lang.annotation.Annotation;
import java.util.Arrays;

class AnnotationUtils {

    public static void printClassAnnotations(Class classObject) {
        // write your code here
        Annotation[] declaredAnnotations = classObject.getDeclaredAnnotations();
        printAnnotations(declaredAnnotations);

    }

    private static void printAnnotations(Annotation[] declaredAnnotations) {
        for (Annotation declaredAnnotation : declaredAnnotations) {
            System.out.println(declaredAnnotation.annotationType().getSimpleName());
        }
    }


}
