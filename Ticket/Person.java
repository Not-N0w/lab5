package Ticket;

public class Person {

    private final double weightLimit = 0;

    private java.time.LocalDate birthday; //Поле не может быть null
    private double weight; //Значение поля должно быть больше 0
    private String passportID; //Строка не может быть пустой, Поле может быть null
    private Location location; //Поле может быть null

    public Person() {

    }

    public java.time.LocalDate birthday() {
        return this.birthday;
    }

    public double weight() {
        return this.weight;
    }

    public String passportID() {
        return this.passportID;
    }

    public Location location() {
        return this.location;
    }


    public void setBirthday(java.time.LocalDate birthday) {
        if(birthday != null) {
            this.birthday = birthday;
        }
        else {
            String message = "Birthday is null, but it should not be null!";
            throw new IllegalArgumentException(message);
        }
    }

    public void setWeight(double weight) {
        if(weight > weightLimit) {
            this.weight = weight;
        }
        else {
            String message = "Weight is "+ String.valueOf(weight)  + ", but it should be more than " + String.valueOf(weightLimit) + "!";
            throw new IllegalArgumentException(message);
        }
    }

    public void setPassportID(String passportID) {
        if(passportID == null) {
            String message = "PassportID is null, but it should not be null!";
            throw new IllegalArgumentException(message);
        }
        else if(passportID.isEmpty()) {
            String message = "PassportID is empty, but it should not be empty!";
            throw new IllegalArgumentException(message);
        }
        this.passportID = passportID;
    }

    public void setLocation(Location location) {
        if(location == null) {
            String message = "Location is null, but it should not be null!";
            throw new IllegalArgumentException(message);
        }
        this.location = location;
    }

}