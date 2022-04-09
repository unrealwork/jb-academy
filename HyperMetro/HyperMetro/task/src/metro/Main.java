package metro;

import com.google.gson.JsonSyntaxException;
import metro.commands.StorageCommand;
import metro.commands.StorageCommandFactory;
import metro.storage.SubwayStorage;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String path = args[0].endsWith("prague.json") ?
                args[0].replace("prague.json", "prague_c.json") : args[0];
        Path pathToFile = Paths.get(path);
        try (Scanner scanner = new Scanner(System.in)) {
            SubwayStorage subwayStorage = SubwayStorage.fromJsonFile(pathToFile.endsWith("prague_w_time.json") ? pathToFile : pathToFile);
            while (true) {
                final StorageCommand storageCommand = StorageCommandFactory.fromCommand(scanner.nextLine());
                storageCommand.run(subwayStorage);
            }
        } catch (IOException e) {
            System.out.println("Error! Such a file doesn't exist!");
        } catch (JsonSyntaxException e) {
            System.out.println("Incorrect file");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
