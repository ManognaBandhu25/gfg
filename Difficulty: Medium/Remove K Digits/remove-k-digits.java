class Solution {
    public String removeKdig(String s, int k) {
        // code here
        Stack<Character> st = new Stack<>();
        int count = 0;
        int len = s.length();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < len) {
            if (st.isEmpty()) {
                st.push(s.charAt(i));
            } else {
                while (!st.isEmpty() && (st.peek() - '0') > s.charAt(i) - '0') {
                    if (count != k) {
                        st.pop();
                        count++;
                    } else {
                        break;
                    }
                }
                st.push(s.charAt(i));
            }
            i++;
        }
        while(count < k){
            st.pop();
            count++;
        }
        if (st.isEmpty()) {
            return "0";
        }
        while (!st.isEmpty()) {
            char val = st.pop();
            sb.append(val);
        }
        sb.reverse();

        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}