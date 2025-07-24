class Solution {
    // Function to remove duplicates from the given array.
    ArrayList<Integer> removeDuplicates(int[] arr) {
        // code here
          int j=0;
        for(int i=1;i<arr.length;i++){
            if(arr[j]!=arr[i]){
                j++;
                arr[j]=arr[i];
            }
        }
             ArrayList<Integer> result = new ArrayList<>();
             for (int i = 0; i <= j; i++) {
                   result.add(arr[i]);
             }
               return result;
    }
}
