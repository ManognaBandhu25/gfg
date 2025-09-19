class Solution {
    public int minParentheses(String s) {
        // code here
        int n=s.length();
        int ans=0;
        int open=0;
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            if(c=='(')open++;
            else 
            {
                if(open==0)ans++;
                else open--;
            }
        }
       return ans+open;
        
    }
}