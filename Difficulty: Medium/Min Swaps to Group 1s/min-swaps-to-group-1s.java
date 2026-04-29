class Solution {
    public int minSwaps(int[] arr) {
        int n=arr.length,c=0;
        for(int i=0;i<n;i++){
            if(arr[i]==1)
                c++;
        }
        if(c==0)
            return -1;
        if(c==1)
            return 0;
        int res=Integer.MAX_VALUE,zc=0;
        for(int i=0;i<c;i++){
            if(arr[i]==0)
                zc++;
        }
        res=Math.min(res,zc);
        for(int j=c;j<n;j++){
            if(arr[j-c]==0)
                zc--;
            if(arr[j]==0)
                zc++;
            res=Math.min(res,zc);
        }
        return res;
    }
}