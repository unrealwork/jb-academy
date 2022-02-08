import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class MethodsDemo {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        // write your code here
        Method[] methods = SomeClass.class.getDeclaredMethods();
        if (methods.length > 0) {
            methods[0].setAccessible(true);
            Object res = methods[0].invoke(SomeClass.class);
            System.out.println(res);
        }
    }
}
