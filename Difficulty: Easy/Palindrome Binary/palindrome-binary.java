class Solution {
    public boolean isBinaryPalindrome(int n) {
        // code here
        String s=Integer.toBinaryString(n);
        int left=0,right=s.length()-1;
        while(left<=right){
            char leftChar=s.charAt(left);
            char rightChar=s.charAt(right);
            if(leftChar!=rightChar){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
};