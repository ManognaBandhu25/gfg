import java.util.*;
class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        long sum = 0;
        int len=0;
        HashMap<Long,Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
            if(sum==k){
                len = Math.max(len,i+1);
            }
            long rem = sum-k;
            if(map.containsKey(rem)){
                len = Math.max(i-map.get(rem),len);
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
            
        }
        return len;
    }
}