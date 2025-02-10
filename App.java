
class App {

    public static void a(int x) {
        if(x == 1) {
            throw new IllegalArgumentException("asd");
        }
        System.err.println(123);
    }
    public static void main(String[] args) {
        try {
            a(2);
        }
        catch(IllegalArgumentException exception) {
            System.err.println(exception.getMessage());
        }
    }
}