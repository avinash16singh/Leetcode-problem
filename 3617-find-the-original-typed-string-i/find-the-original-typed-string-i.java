import java.util.*;

public class Solution {
    public int possibleStringCount(String word) {
        Set<String> result = new HashSet<>();
        result.add(word); // original word is valid

        for (int i = 0; i < word.length(); ) {
            int j = i;
            while (j < word.length() && word.charAt(j) == word.charAt(i)) {
                j++;
            }
            int len = j - i;

            // Try removing characters from the group (only once)
            for (int k = 1; k < len; k++) {
                StringBuilder sb = new StringBuilder();
                sb.append(word.substring(0, i));
                for (int x = 0; x < k; x++) sb.append(word.charAt(i));
                sb.append(word.substring(j));
                result.add(sb.toString());
            }
            i = j;
        }

        return result.size();
    }
}
