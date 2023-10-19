package myanswer01;

public class Main {
    public static void main(String[] args) {
        String url = args[0];

        MyClient client = new MyClient();
        client.saveHeaderAndBody(url);
        client.saveHeaderAndBody("https://httpbin.org/status/400");
    }
}
