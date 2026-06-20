class Solution {
    public int getLastDigit(String a, String b) {
        // code here
          int m=a.length(),n=b.length();

      if(n==1&&b.charAt(0)=='0')

      return 1;

      if(m==1&&a.charAt(0)=='0')

      return 0;

      int num=0;

      for(int i=0;i<n;i++){

          num=(num*10+b.charAt(i)-'0')%4;

 

      }

     num=num%4==0?4:num%4;

     int ans=(int)Math.pow(a.charAt(m-1)-'0',num);

     return ans%10;
    }
};