package client;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Common.Coordinates;
import Common.DataContainer;
import Common.Location;
import Common.Person;
import Common.Ticket;
import Common.TicketType;

public class CommandDataParser {
    private Scanner scanner;

    public CommandDataParser(Scanner scanner) {
        this.scanner = scanner;
    }

    private Coordinates parseCoordinates(int tabs) {
        Coordinates coordinates = new Coordinates();

        fieldOut(tabs, "Coordinates->");
        tabs += 1;
        fieldOut(tabs, "X: ");
        coordinates.setX(scanner.nextInt());

        fieldOut(tabs, "Y: ");
        coordinates.setY(scanner.nextFloat());
        return coordinates;
    }

    private LocalDate dateParse(String dateString) {
        LocalDate localDate = LocalDate.parse(dateString);
        return localDate;
    }

    private Location parseLocation(int tabs) {
        Location location = new Location();

        fieldOut(tabs, "Location->");
        tabs += 1;
        fieldOut(tabs, "X: ");
        location.setX(scanner.nextFloat());

        fieldOut(tabs, "Y: ");
        location.setY(scanner.nextFloat());

        fieldOut(tabs, "Z: ");
        location.setZ(scanner.nextLong());

        return location;
    }

    private Person parsePerson(int tabs) {
        Person person = new Person();
        fieldOut(tabs, "Person->");
        tabs += 1;

        fieldOut(tabs, "Birthday: ");
        String date = scanner.next();
        person.setBirthday(dateParse(date));

        fieldOut(tabs, "Weight: ");
        person.setWeight(scanner.nextDouble());
        
        fieldOut(tabs, "PassportID: ");
        person.setPassportID(scanner.next());

        fieldOut(tabs, "Weight: ");
        person.setWeight(scanner.nextDouble());

        person.setLocation(parseLocation(tabs));
        
        return person;
    }

    private void fieldOut(int tabs, String in) {
        System.out.print( "    ".repeat(tabs) + in);
    }


    private Ticket parseTicket() {
        Ticket ticket = new Ticket();
        int tabs = 0;

        fieldOut(tabs, "Ticket->");
        tabs += 1;
        fieldOut(tabs, "Name: ");
        ticket.setName(scanner.next());

        ticket.setCoordinates(parseCoordinates(tabs));

        fieldOut(tabs, "Price: ");
        ticket.setPrice(scanner.nextInt());

        fieldOut(tabs, "Refundable: ");
        ticket.setRfundable(scanner.nextBoolean());

        fieldOut(tabs, "Ticket Type (VIP, USUAL, BUDGETARY, CHEAP): ");
        ticket.setType(TicketType.valueOf(scanner.next()));

        ticket.setPerson(parsePerson(tabs));

        return ticket;
    }
    private Integer parseInteger() {
        Integer result;
        result = scanner.nextInt();
        return result;
    }
    private String parseString() {
        String result;
        result = scanner.next();
        return result;
    }
    private Boolean parseBoolean() {
        Boolean result;
        result = scanner.nextBoolean();
        return result;
    }

    public DataContainer parse(String command) {
        switch (command) {
            case "add", "add_if_max", "add_if_min", "remove_greater":
                return  new DataContainer(command, null, parseTicket(), null, null);
            case "remove_by_id":
                return  new DataContainer(command,null, null, parseInteger(), null);
            case "execute_script":
                return new DataContainer(command,null, null, null, parseString());
            case "count_greater_than_refundable","filter_greater_than_refundable":
                return  new DataContainer(command,parseBoolean(), null, null, null);
            case "update":
                return  new DataContainer(command,null, parseTicket(), parseInteger(), null);
            default:
                return null;
        }
    }
}
