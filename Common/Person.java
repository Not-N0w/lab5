package Common;

import utils.ValueChecker;

public class Person {

    private final double weightLimit = 0;

    private java.time.LocalDate birthday; //Поле не может быть null
    private double weight; //Значение поля должно быть больше 0
    private String passportID; //Строка не может быть пустой, Поле может быть null
    private Location location; //Поле может быть null

    public Person(java.time.LocalDate birthday, double weight, String passportID, Location location) {
        try {
            setBirthday(birthday);
            setLocation(location);
            setPassportID(passportID);
            setWeight(weight);
        } 
        catch(IllegalArgumentException exception) {
            throw new IllegalArgumentException( this.getClass() + ": " + exception.getMessage(), exception);
        }
    }
    public Person() {}


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
        ValueChecker.nullCheck(birthday, "Birthday");
        this.birthday = birthday;
    }

    public void setWeight(double weight) {
        ValueChecker.checkLimits(weight, weightLimit, null, "Weight");
        this.weight = weight;
    }

    public void setPassportID(String passportID) {
        ValueChecker.nullCheck(passportID, "PassportID");
        ValueChecker.stringEmptyCheck(passportID, "PassportID");
        this.passportID = passportID;
    }

    public void setLocation(Location location) {
        ValueChecker.nullCheck(location, "Location");

        this.location = location;
    }
    @Override
    public String toString() {
        String result = "Person ->\n";
        result += "Birthday: " + birthday.toString() + "\n";
        result += "Weight: " + String.valueOf(weight) + "\n";
        result += "PassportID: " + passportID + "\n";
        result += location.toString();
        return result;
    }

}