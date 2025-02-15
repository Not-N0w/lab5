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
            output.outSub("Waiting for commands");
            String command;
            DataContainer commandData;
            try {
                command = input.getCommand();
                commandData = input.getData(command);
                System.out.println(commandData.toString());

            } 
            catch(IllegalArgumentException exception) {
                output.outError(exception.getMessage());
                output.outError("Try again\n");
            }

            // send to server
        }
    }

    public void run() {
        try {
            if(!filePath.equals("")) {
                String fileData = input.getFileData();
                ticketController.addJSONData(fileData);
                output.successfulFileDataLoaded(filePath);
            } 
            else {
                // make new file
            }
        } 
        catch(FileNotFoundException exception) {
            output.fileNotExistMessage(filePath);
        }
        commandCycle();
    }
    
    private void pushCommand(String command, String args) {}
}
