package Common;

public record DataContainer(String command, Boolean refundable, Ticket ticket, Integer id, String fileName) {

    @Override
    public String toString() {
        String result = "DataContainer ->\n";
        result += "Command: " + command + "\n";
        result += "Refundable: " + String.valueOf(refundable) + "\n";
        result += ticket.toString();
        result += "ID: " + String.valueOf(id) + "\n";
        result += "FileName: " + fileName + "\n";
        return result;
    }

} 


