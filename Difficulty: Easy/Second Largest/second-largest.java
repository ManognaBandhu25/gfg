class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int max = arr[0];
        
        for(int i =0 ;i< arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
            if(map.containsKey(arr[i])){
                map.put(arr[i] , map.get(arr[i])+1);
            }else{
                map.put(arr[i] , 1);
            }
        }
        map.remove(max);
        int temp = -1;
        
       for(Integer val : map.keySet()){
           if( val > temp){
               temp = val;
           }
       }
     
        return temp;
    }
}