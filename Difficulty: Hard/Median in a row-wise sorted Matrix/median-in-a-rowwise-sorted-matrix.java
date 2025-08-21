class Solution {
    int median(int mat[][]) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                pq.add(mat[i][j]);
            }
        }
        
        int length = pq.size();
        
        for(int i=0; i<length/2; i++){
            pq.remove();
        }
        
        return pq.peek();
    }
}