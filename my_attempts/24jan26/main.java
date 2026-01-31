import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

class Main {
    public static void main(String[] args) {
        // List<String> my_list = new ArrayList<>();
        Collection<String> my_list = new HashSet<>();
        
        my_list.add("hello");
        my_list.add("hello");
        my_list.add("hello");
        
        
        System.out.println(my_list);
    }
}