class Solution {
    public boolean wifiRange(String s, int x) {
        int n = s.length();
        int lastCovered = -1;

        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == '1') {

                int left = i - x;
                int right = i + x;

                if (left > lastCovered + 1) {
                    return false;
                }

                lastCovered = Math.max(lastCovered, right);
            }
        }

        
        return lastCovered >= n - 1;
        
    }
}