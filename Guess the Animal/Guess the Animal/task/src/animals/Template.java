package animals;

public interface Template {
    String format(String template, Object... objs);

    static Template create() {
        return new TemplateImpl();
    }

}
