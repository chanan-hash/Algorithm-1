/**
 * This class in an implementation for Longest Common Prefix
 * By a givven array of words, we want to find the "Longest Common Prefix"
 * The idea of the algorithm is very similar to mergeSort that why the complexity will also be O(nlog(n))
 * <p>
 * Link for the video that is based on:
 * https://www.youtube.com/watch?v=BL_Dq18zccI&list=PL9syuH7KOKcZE0Tpg4xFR3NefsY57Aj7M&index=2&t=8s
 */

public class LCP {
    public static void main(String[] args) {
        String[] str = {"algebra", "algorithm", "algory", "algeirs"};
        String[] str1 = {"geeksforgeeks", "geeks", "geek", "geezer"};

        String str2 = common_prefix(str[0], str[1]);
        System.out.println(str2);
        String str3 = common_prefix(str1[0], str1[1]);
        System.out.println("\n" + str3);

        System.out.println(LCP(str, 0, str.length-1));
        System.out.println(LCP(str1));
    }

    public static String LCP(String[] str){
        return LCP(str,0,str.length-1);
    }

    // O(nlog(n))
    public static String LCP(String[] str, int low, int high) {
        if (low == high) {
            return str[low];
        }
        int mid = (low + high) / 2;
        String lcpL = LCP(str, low, mid);
        String lcph = LCP(str, mid + 1, high);
        return common_prefix(lcpL, lcph);
    }

    // By given two Strings, we want to check their LCP, O(n)
    public static String common_prefix(String s1, String s2) {
        int length = Math.min(s1.length(), s2.length()); // To know till where to run
        for (int i = 0; i < length; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.substring(0, i); // The substring function return till the number -1, if it till i, so it return till i-1
            }
        }
        return s1.substring(0, length);
    }
}
