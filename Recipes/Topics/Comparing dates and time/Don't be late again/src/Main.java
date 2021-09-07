import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;

class Main {
    private static final LocalTime STORE_TIME = LocalTime.parse("20:00");
    
    public static void main(String[] args) throws IOException {
        // put your code here
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.parseInt(reader.readLine());
            reader.lines()
                    .limit(size)
                    .map(Record::parseRecord)
                    .filter(r -> r.time.isAfter(STORE_TIME))
                    .map(r -> r.name)
                    .forEach(System.out::println);
        }
    }
    
    
    private static final class Record {
        private final String name;
        private final LocalTime time;

        private Record(String name, LocalTime time) {
            this.name = name;
            this.time = time;
        }
        
        private static Record parseRecord(final String line) {
            String[] parts = line.split(" ");
            return new Record(parts[0], LocalTime.parse(parts[1]));
        }
    }
}
