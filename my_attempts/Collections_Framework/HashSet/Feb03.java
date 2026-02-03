import java.util.HashSet;
import java.util.Set;

public class Feb03 {
    public static void main(String[] args) {

        // Set<Integer> scores = new HashSet<>(Set.of(1,2,3,4));

        Set<Integer> scores = new HashSet<>();
        scores.add(1);
        scores.add(1);
        scores.add(1);
        System.out.println(scores); // [1]
    }
}
