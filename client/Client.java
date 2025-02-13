package client;

import java.io.FileNotFoundException;

import Common.DataContainer;
import ticketController.TicketController;

public class Client {
    private Input input;
    private Output output;
    private final String filePath;
    private TicketController ticketController;

    public Client() {
        filePath = "";

        input = new Input(filePath);
        output = new Output();
    }
    public Client(String filePath) {
        this.filePath = filePath;

        input = new Input(filePath);
        output = new Output();
    }


    private void commandCycle() {
        while(true) {
            output.out("Waiting for commands");
            String command = input.getCommand();
            DataContainer commandData = input.getData(command);
            // send to server
        }
    }

    public void run() {
        try {
            String fileData = input.getFileData();
            ticketController.addJSONData(fileData);
            output.successfulFileDataLoaded(filePath);
        } 
        catch(FileNotFoundException exception) {
            output.fileNotExistMessage();
        }
        catch(Exception exception) {
            output.out("хз");
        }
        commandCycle();
    }
    
    void pushCommand(String command, String args) {
        
    }
}
