package myanswer01;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.util.concurrent.TimeUnit.SECONDS;

public class MyClient {
    private final OkHttpClient client;

    public MyClient() {
        client = new OkHttpClient.Builder()
                .connectTimeout(10, SECONDS)
                .readTimeout(10, SECONDS)
                .writeTimeout(10, SECONDS)
                .build();
    }

    public void saveHeaderAndBody(String url) {
        try (
                Response response = client.newCall(
                        new Request.Builder()
                                .url(url)
                                .get()
                                .build()
                ).execute()
        ) {
            if (response.isSuccessful()) {
                System.out.println(response.code());
                saveHeader(response);
                saveBody(response);
            } else {
                System.err.println(response.code());
                System.err.println(response.message());
                System.exit(1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveHeader(Response response) throws IOException {
        writeFile("header.txt", response.headers().toString());
    }

    private void saveBody(Response response) throws IOException {
        writeFile("body.txt", response.body().string());
    }

    private void writeFile(String filename, String write) throws IOException {
        try (
                BufferedWriter writer = Files.newBufferedWriter(
                        Path.of("./contents/085/src/main/resources/" + filename)
                )
        ) {
            writer.write(write);
        }
    }
}
