class Solution {
    public static boolean checkRedundancy(String s) {
        // code here
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            if(!st.isEmpty() && curr == ')') {
                char next = st.pop();
                if(next == '(') return true;
                boolean isOperator = false;
                while (!st.isEmpty() && next != '(') {
                    if(next == '+' || next == '-' || next == '/' || next == '*')
                        isOperator = true;
                    next = st.pop();
                }
                if(!isOperator) return true;
            } else st.push(curr);
        }
        return false;
    }
}
