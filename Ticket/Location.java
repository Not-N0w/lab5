package Ticket;

public class Location {

    private Float x; //Поле не может быть null
    private Float y; //Поле не может быть null
    private Long z; //Поле не может быть null


    public Location(Float x, Float y, Long z) {
        try {
            this.setX(x);
            this.setY(y);
            this.setZ(z);
        } 
        catch(IllegalArgumentException exception) {
            throw new IllegalArgumentException( this.getClass() + ": " + exception.getMessage(), exception);
        }
    }

    public Float x() {
        return this.x;
    }
    public Float y() {
        return this.y;
    }
    public Long z() {
        return this.z;
    }

    public void setX(Float x) {
        if(x != null) {
            this.x = x;
        }
        else {
            String message = "X coordinate is null, but it should not be null!";
            throw new IllegalArgumentException(message);
        }
    }

    public void setY(Float y) {
        if(y != null) {
            this.y = y;
        }
        else {
            String message = "Y coordinate is null, but it should not be null!";
            throw new IllegalArgumentException(message);
        }
    }

    public void setZ(Long z) {
        if(z != null) {
            this.z = z;
        }
        else {
            String message = "Z coordinate is null, but it should not be null!";
            throw new IllegalArgumentException(message);
        }
    }
}