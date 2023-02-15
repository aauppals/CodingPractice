import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class hashMapPractice {

    public static void main(String[] args) {


        Set<Integer> values = new TreeSet<>();
        values.add(1);
        values.add(6);
        values.add(4);
        values.add(10);
        values.add(7);

//        for (int i : values) {
//            System.out.println(i);
//        }

        Map<Integer, String> map = new HashMap<>();

        map.put(1, "Ahmad");
        map.put(2, "Jack");
        map.put(3, "Sill");
        map.put(4, "Kess");
        map.put(5, "Tory");
        map.put(6, "Zelensky");
        map.put(7, "Uppal");
        map.put(8, "Peter");

        Set<Integer> keys = map.keySet();

//        for (int i : keys) {
//            System.out.println((i) +  "  "+ map.get(i));
//        }

        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();

        for (Map.Entry<Integer, String> e : entrySet) {
            System.out.println("Key: " + e.getKey() + " Value: " + e.getValue());
        }
    }

}

