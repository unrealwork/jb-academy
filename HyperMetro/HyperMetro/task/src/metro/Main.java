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
        Path pathToFile = Paths.get(args[0]);
        try (Scanner scanner = new Scanner(System.in)) {
            SubwayStorage subwayStorage = SubwayStorage.fromJsonFile(pathToFile);
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
