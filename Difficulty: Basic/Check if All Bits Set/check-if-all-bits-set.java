class Solution {
    public boolean isBitSet(int n) {
        // code here
        if(n==0){
            return false;
        }
        int num=(n+1);
        while(num > 1){
            int dig=num % 2;
            if(dig != 0){
                return false;
            }
            num=num / 2; 
        }
        return true;
    }
};