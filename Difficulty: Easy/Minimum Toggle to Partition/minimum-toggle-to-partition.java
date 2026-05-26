class Solution {
    int minToggle(int[] arr) {
        // code here
        int one = 0;
        int ans = 0;
        for(int x : arr){
            if(x==1){
                one++;
            } else{
                ans = Math.min(ans+1,one);
            }
        }
        return ans;
    }
}