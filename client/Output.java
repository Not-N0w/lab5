package client;

public class Output {
    public void fileNotExistMessage() {
        out("Файл не найден");
    }
    public void successfulFileDataLoaded(String path) {}

    public void out(String iString) {
        System.out.println(iString);
    }
}
