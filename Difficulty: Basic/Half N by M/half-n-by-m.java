class Solution{
    static int mthHalf(int N, int M){
        // code here
        int first=0;
       
        int temp = N;
        for(int i=1;i<M;i++){
           first = temp/2;
           temp = first;
        }
        return temp;
    }
}