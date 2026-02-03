// package my_attempts.Collections_Framework.HashMap;

import java.util.HashMap;
import java.util.Map;

public class Feb03 {
    public static void main(String[] args) {

        // Map<String, Integer> scores = new HashMap<>(Map.of("test1", 1));

        Map<String, Integer> scores = new HashMap<>();
        scores.put("Math", 90);
        scores.put("English", 85);
        scores.put("Science", 95);

        System.out.println(scores);
    }
}
