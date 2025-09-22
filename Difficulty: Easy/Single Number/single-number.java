// User function Template for Java

class Solution {
    int getSingle(int arr[]) {
        // code here
        int xor = 0;
        for(int num:arr) xor^=num;
        return xor;
    }
}