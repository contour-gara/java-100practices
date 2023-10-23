package myanswer01;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Scanner;

public final class JsonUtil {
    private JsonUtil() {
    }

    public static <T> T unmarshal(String[] args, Class<T> clazz) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(createJson(args), clazz);
    }

    public static void marshal(Object object) {
        Gson gson = new GsonBuilder().serializeNulls().create();
        System.out.println(gson.toJson(object));
    }

    private static String createJson(String[] args) {
        // switch式に変更
        if (args[0].equals("-d")) return getJson();
        if ((args[0].equals("-s")) && (args.length == 3))
            return String.format("{\"id\":%s,\"name\":%s}", args[1], args[2]);
        if ((args[0].equals("-s")) && (args.length == 4))
            return String.format("{\"id\":%s,\"name\":%s,\"description\":%s}", args[1], args[2], args[3]);

        throw new RuntimeException("第一引数は-sか-d");
    }

    private static String getJson() {
        System.out.print("JSON を入力してください。: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
