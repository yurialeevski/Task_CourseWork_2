
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //String inputString = "yourapp The quick Brown fox jumps over the lazy dog";
        String inputString = scanner.nextLine();
        System.out.println(inputString);
        String text = inputString.toLowerCase();
        List<String> textStrings = List.of(text.split(" "));
        long count = textStrings.stream().count();
        System.out.println("В тексте " + count + " слов(а)");
        Map<String, Integer> stringTimes = textStrings.stream()
                .collect(() -> new HashMap<>(),
                (mapHashMap, string) -> mapHashMap.put(string, mapHashMap.containsKey(string) ? (mapHashMap.get(string) + 1) : 1)
                , HashMap::putAll);
        stringTimes.forEach((k, v) -> System.out.println(k + " -> " + v));
        System.out.println("\nTop - 10:");
        stringTimes.entrySet().stream()
                .sorted(Comparator.<Map.Entry<String, Integer>>comparingInt(entry -> entry.getValue())
                        .reversed()
                        .thenComparing(entry -> entry.getKey()))
                .limit(10)
                .forEach(entry -> System.out.println(entry.getValue() + " - " + entry.getKey()));
    }
}