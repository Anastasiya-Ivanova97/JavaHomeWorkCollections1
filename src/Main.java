
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            byte[] array = Files.readAllBytes(Paths.get("C:\\Users\\ASUS\\Desktop\\data.txt"));
            String bytes = new String(array);
            String[] ss = bytes.split("\\s|\\W|\\.");
            ArrayList<String> strings = new ArrayList<>(Arrays.asList(ss));
            Collections.sort(strings);
            System.out.println(strings.toString());
            TreeMap<String, Integer> treeMap = new TreeMap<>();

            for (int i = 0; i < strings.size(); i++) {
                treeMap.put(strings.get(i), Collections.frequency(strings, strings.get(i)));
            }
            for (Map.Entry<String, Integer> entry: treeMap.entrySet()) {
                System.out.println(entry.getKey()+" : "+ entry.getValue());
            }
            Integer max = 0;
            for (Integer ii : treeMap.values()) {
                if (max < ii) {
                    max = ii;
                }
            }
            Collection<String> collection = treeMap.keySet();
            for (String key : collection) {
                Object obj = treeMap.get(key);
                if (key != null) {
                    if (max.equals(obj)) {
                        System.out.println("Самое часто встречающееся слово: " + key + "Его частота: " + max);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }
    }
}
