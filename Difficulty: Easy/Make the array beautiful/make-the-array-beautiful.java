class Solution {
    List<Integer> makeBeautiful(int[] arr) {
        
        ArrayList<Integer> ans= new ArrayList<>();
        int i=0;
        
        for(int k: arr){
            ans.add(k);
        }
        
        while(i<ans.size()-1){
            int p=ans.get(i)>>31;
            int q=ans.get(i+1)>>31;
            if((p==-1 && q==-1)||(p==0 && q==0)){//checking if both numbers ar positive/zero or negative
                i++;
                
            }
            else{
                ans.remove(i+1);
                ans.remove(i);
                i=0;
            }
        }
        
        return ans;
    }
}