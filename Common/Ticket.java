package Common;

import utils.ValueChecker;

public class Ticket {
    static Long nextID = Long.valueOf(1);

    private final int priceLimit = 0;

    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int price; //Значение поля должно быть больше 0
    private Boolean refundable; //Поле не может быть null
    private TicketType type; //Поле не может быть null
    private Person person; //Поле может быть null
    
    public Ticket(String name, Coordinates coordinates, int price, Boolean refundable, TicketType type, Person person) {
        super();
        try {
            setName(name);
            setCoordinates(coordinates);
            setPrice(price);
            setRfundable(refundable);
            setType(type);
            setPerson(person);
        } 
        catch(IllegalArgumentException exception) {
            throw new IllegalArgumentException( this.getClass() + ": " + exception.getMessage(), exception);
        }
    }
    public Ticket() {
        this.id = nextID++;
    }


    public Long id() {
        return this.id;
    }
    public String name() {
        return this.name;
    }
    public Coordinates coordinates() {
        return this.coordinates;
    }
    public java.time.LocalDateTime creationDate() {
        return this.creationDate;
    }
    public int price() {
        return this.price;
    }
    public Boolean refundable() {
        return this.refundable;
    }
    public TicketType type() {
        return this.type;
    }
    public Person person() {
        return this.person;
    }

    public void setName(String name) {
        ValueChecker.nullCheck(name, "name");
        ValueChecker.stringEmptyCheck(name, "name");
        this.name = name;
    }
    public void setCoordinates(Coordinates coordinates) {
        ValueChecker.nullCheck(coordinates, "coordinates");
        this.coordinates = coordinates;
    }
    public void setPrice(int price) {
        ValueChecker.checkLimits(price, priceLimit, null, "price");
        this.price = price;
    }
    public void setRfundable(Boolean refundable) {
        ValueChecker.nullCheck(refundable, "refundable");
        this.refundable = refundable;
    }
    public void setType(TicketType type) {
        ValueChecker.nullCheck(type, "type");
        this.type = type;
    }
    public void setPerson(Person person) {
        ValueChecker.nullCheck(person, "person");
        this.person = person;
    }

}