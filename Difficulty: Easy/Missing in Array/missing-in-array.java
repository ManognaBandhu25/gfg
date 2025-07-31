class Solution {
    int missingNum(int arr[]) {
        // code here
        long n = arr.length + 1;
        double total = n * (n + 1) / 2;
        double sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return (int)(total - sum);
        
    }
}