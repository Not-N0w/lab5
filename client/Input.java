package client;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Common.DataContainer;
import Common.Ticket;

public class Input {
    private Scanner fileScanner;
    private File file;
    private Scanner scanner;
    private CommandDataParser commandDataParser;


    Input() {
        scanner = new Scanner(System.in);
        commandDataParser = new CommandDataParser(scanner);
    }
    Input(String filePath) {
        this();
        file = new File(filePath);
    }

    String getFileData() throws FileNotFoundException {
        fileScanner = new Scanner(file);
        fileScanner.useDelimiter("\\A");
        String fileContent = fileScanner.hasNext() ? fileScanner.next() : "";
        return fileContent;
    }
    public String getCommand() {
        String command = scanner.next();
        return command;
    }

    public DataContainer getData(String command) {
        DataContainer container = commandDataParser.parse(command);
        return container;
    }
}

