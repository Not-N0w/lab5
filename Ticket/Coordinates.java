package Ticket;

public class Coordinates {

    private final int xLimit = -47;
    private final double yLimit = -69;
    
    private int x; //Значение поля должно быть больше -47
    private float y; //Значение поля должно быть больше -69


    public Coordinates(int x, float y) {
        try {
            setX(x);
            setY(y);
        } catch(IllegalArgumentException exception) {
            throw new IllegalArgumentException( this.getClass() + ": " + exception.getMessage(), exception);
        }
    }


    public int x() {
        return x;
    }

    public double y() {
        return y;
    }


    public void setX(int x) {
        if(x > xLimit) {
            this.x = x;
        }
        else {
            String message = "X coordinate is "+ String.valueOf(x)  + ", but it should be more than " + String.valueOf(xLimit) + "!";
            throw new IllegalArgumentException(message);
        }
    }

    public void setY(float y) {
        if(y > yLimit) {
            this.y = y;
        }
        else {
            String message = "Y coordinate is "+ String.valueOf(y)  + ", but it should be more than " + String.valueOf(yLimit) + "!";
            throw new IllegalArgumentException(message);
        }
    }
}