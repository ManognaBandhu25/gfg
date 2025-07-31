class Solution {
    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        // code here
          ArrayList<Integer> row = new ArrayList<>();
        long value = 1;
        
        row.add((int)value);
        
        for (int k = 1; k <n; k++) {
            value = value * (n - k);
            value = value / k;
            row.add((int)value);
        }
        
        return row;
    }
}