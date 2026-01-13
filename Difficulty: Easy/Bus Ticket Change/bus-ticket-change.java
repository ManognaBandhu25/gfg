class Solution {
    public boolean canServe(int[] arr) {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(5 , 0);
        map.put(10 , 0);
        map.put(20 , 0);
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == 5){
                map.put(5 , map.getOrDefault(5 , 0) + 1);
            }else if(arr[i] == 10){
                map.put(5 , map.getOrDefault(5 , 0) - 1);
                if(map.get(5) < 0){
                    return false;
                }
                map.put(10 , map.getOrDefault(10 , 0) + 1);
            }else{
                if(map.get(10) > 0){// If i have $10 then try to give them
                    map.put(10 , map.getOrDefault(10 , 0) - 1);
                    if(map.get(10) < 0){
                        return false;
                    }
                    map.put(5 , map.getOrDefault(5 , 0) - 1);
                    if(map.get(5) < 0){
                        return false;
                    }
                }else{//Otherwise you must give 3 $5 
                    map.put(5 , map.getOrDefault(5 , 0) - 3);
                    if(map.get(5) < 0){
                        return false;
                    }
                }
                map.put(20 , map.getOrDefault(20 , 0) + 1);
            }
        }
        return true;
    }
}