class Solution {
    public boolean isSumString(String s) {
        int n = s.length();
        // Try every possible pair of first and second number
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; j < n - i; j++) {
                String s1 = s.substring(0, i);
                String s2 = s.substring(i, i + j);
                
                // Skip if any number has leading zeroes (except "0" itself)
                if ((s1.length() > 1 && s1.charAt(0) == '0') ||
                    (s2.length() > 1 && s2.charAt(0) == '0')) {
                    continue;
                }

                if (checkSumString(s1, s2, s.substring(i + j))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkSumString(String s1, String s2, String remaining) {
        String sum = addStrings(s1, s2);
        if (!remaining.startsWith(sum)) {
            return false;
        }
        if (remaining.equals(sum)) {
            return true;
        }
        return checkSumString(s2, sum, remaining.substring(sum.length()));
    }

    private String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        
        while (i >= 0 || j >= 0 || carry != 0) {
            int digit1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int digit2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        
        return sb.reverse().toString();
    }
}
