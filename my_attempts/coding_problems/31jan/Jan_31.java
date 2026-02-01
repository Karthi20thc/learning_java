public class Jan_31 {
    public static void main(String[] args){
        System.out.println(isPalindrome("abba"));
    }

    public static boolean isPalindrome(String s){
        int left_index = 0;
        int right_index = s.length()-1;

        while(left_index < right_index){

            boolean pal_cond = s.charAt(left_index) != s.charAt(right_index);

            if(pal_cond){
                return false;
            }
            else{
            left_index++;
            right_index--;
            }

        }

        return true;
    }
}
