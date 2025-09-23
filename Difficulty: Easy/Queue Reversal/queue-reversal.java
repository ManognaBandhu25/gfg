class Solution {
    public void reverseQueue(Queue<Integer> q) {
        // code here
        
        int arr[] = new int[q.size()];
        for(int i=0;i<arr.length;i++){
            arr[i]=q.remove();
        }
        
        for(int j=arr.length -1 ;j >= 0 ;j--){
            q.add(arr[j]);
        }
       
    }
}