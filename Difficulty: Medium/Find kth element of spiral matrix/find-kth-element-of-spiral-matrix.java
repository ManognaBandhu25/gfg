class Solution {
    /*You are required to complete this method*/
    int findK(int[][]matrix, int n, int m, int k) {
        // Your code here
         List<Integer> res = new ArrayList<>();
        int top = 0;
        int left = 0;
        int bottom = n - 1;
        int right = m - 1;
        while(top<=bottom && left<=right){
            //L-R
            for(int i = left;i<=right;i++) 
                res.add(matrix[top][i]);
            top++;
            //T-B
            for(int i = top;i<=bottom;i++)
                res.add(matrix[i][right]);
            right--;
            //R-L
            if (top <= bottom)
            for (int i = right; i >= left; i--) 
                res.add(matrix[bottom][i]);
            bottom--;
            //B-T
            if(left<=right)
                for(int i = bottom;i>=top;i-- )
                    res.add(matrix[i][left]);
                left++;
            
        }
        return res.get(k-1);
    }
}

    