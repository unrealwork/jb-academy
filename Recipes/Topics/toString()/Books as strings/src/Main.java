import java.util.Arrays;
import java.util.stream.Collectors;

class Book {

    private String title;
    private int yearOfPublishing;
    private String[] authors;

    public Book(String title, int yearOfPublishing, String[] authors) {
        this.title = title;
        this.yearOfPublishing = yearOfPublishing;
        this.authors = authors;
    }

    @Override
    public String toString() {
        return String.format("title=%s,yearOfPublishing=%d,authors=%s",
                title,  yearOfPublishing,
                Arrays.stream(authors)
                        .collect(Collectors.joining(",","[","]"))
        );
    }
}
