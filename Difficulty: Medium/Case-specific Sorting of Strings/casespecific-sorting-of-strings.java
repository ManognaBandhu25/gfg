import java.util.*;

class Solution {
    public static String caseSort(String s) {
        List<Character> lower = new ArrayList<>();
        List<Character> upper = new ArrayList<>();

        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                lower.add(ch);
            } else {
                upper.add(ch);
            }
        }

        Collections.sort(lower);
        Collections.sort(upper);

        StringBuilder result = new StringBuilder();
        int li = 0, ui = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                result.append(lower.get(li++));
            } else {
                result.append(upper.get(ui++));
            }
        }

        return result.toString();
    }
}
