

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class FileWorker {
    private String s;
    public String getFileName() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        return s;
    }
    public String bytesToString() throws IOException {
        byte[] array = Files.readAllBytes(Paths.get(s));
        return new String(array);
    }
    public ArrayList<String> words() throws IOException {
        String[] ss = bytesToString().split("\\s|\\W|\\.");
        ArrayList<String> strings = new ArrayList<>(Arrays.asList(ss));
        Collections.sort(strings);
        return strings;
    }
    public void printWords() throws IOException {
        System.out.println(words().toString());
    }

    public Map<String, Integer> frequent() throws IOException {
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < words().size(); i++) {
            treeMap.put(words().get(i), Collections.frequency(words(), words().get(i)));
        }
        return treeMap;
    }
    public void printFrequency() throws IOException {
        for (Map.Entry<String, Integer> entry: frequent().entrySet()) {
            System.out.println(entry.getKey()+" : "+ entry.getValue());
        }
    }
    public void printMostFrequent() throws IOException {
        Integer max = 0;
        for (Integer ii : frequent().values()) {
            if (max < ii) {
                max = ii;
            }
        }
        Collection<String> collection = frequent().keySet();
        for (String key : collection) {
            Object obj = frequent().get(key);
            if (key != null) {
                if (max.equals(obj)) {
                    System.out.println("Самое часто встречающееся слово: " + key + "Его частота: " + max);
                }
            }
        }
    }
}
