package myanswer01;

import static myanswer01.JsonUtil.marshal;
import static myanswer01.JsonUtil.unmarshal;

public class Main {
    public static void main(String[] args) {
        Item item1 = new Item(1, "gara", null);
//        marshal(item1);

        // -s 1 gara aiueo
        // -s 1 gara
        // -d
        // {"id":1,"name":"gara","description":"aiueo"}
        // {"id":1,"name":"gara","description":null}
        Item item2 = unmarshal(args, Item.class);
//        Item item2 = unmarshal(new String[]{"-s", "1", "gara", "aiueo"}, Item.class);
//        Item item2 = unmarshal(new String[]{"-s", "1", "gara"}, Item.class);
//        Item item2 = unmarshal(new String[]{"-a", "1", "gara"}, Item.class);
//        Item item2 = unmarshal(new String[]{"-d"}, Item.class);
        System.out.println(item2);
    }
}
