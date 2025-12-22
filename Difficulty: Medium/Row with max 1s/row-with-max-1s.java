class Solution {
    public int rowWithMax1s(int arr[][]) {
        int[] pair = new int[2];
        int n = arr.length;
        int m = arr[0].length;
        
        for(int i=0; i<n;i++){
            int countOf1 = 0;
            
            for(int num : arr[i]){
                if(num == 1){
                    countOf1++;
                }
            }
            
            if(pair[1] < countOf1){
                pair[0] = i;
                pair[1] = countOf1;
            }
        }
        
        return pair[0];
    }
}

