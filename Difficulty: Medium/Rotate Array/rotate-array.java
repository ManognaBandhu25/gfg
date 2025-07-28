// User function Template for Java

class Solution {
    // Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d) {
          int arr1[] = new int[arr.length];
        int k=0;
        d = d % arr.length;
        for(int i=d;i<arr.length;i++) arr1[k++]=arr[i];
        for(int i=0;i<d;i++) arr1[k++]=arr[i];
        for(int i=0;i<arr.length;i++){
            arr[i]=arr1[i];
        }
    }
}