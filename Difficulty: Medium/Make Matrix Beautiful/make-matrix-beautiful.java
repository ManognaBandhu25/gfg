class Solution {
    public static int balanceSums(int[][] mat) {
        
       int n=mat.length;
       int max=-1;
       int sum=0;
       //max
       for(int i=0;i<n;i++){
           sum=0;
           for(int j=0;j<n;j++){
               sum+=mat[i][j];
           }
           
           max=Math.max(sum,max);
           
            sum=0;
           for(int j=0;j<n;j++){
               sum+=mat[j][i];
           }
           
           max=Math.max(sum,max);
       }
        int row[] = new int[n];
        int col[] = new int[n];
        for(int i=0;i<n;i++){
            sum=0;
            for(int j=0;j<n;j++){
                sum+=mat[i][j];
            }
            row[i]=max-sum;
            
            sum=0;
            for(int j=0;j<n;j++){
                sum+=mat[j][i];
            }
            col[i]=max-sum;
        }
        int tcol=0;
        for(int i=0;i<n;i++){
            tcol+=col[i];
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=Math.min(tcol,row[i]);
        }
       return ans;
    }
}