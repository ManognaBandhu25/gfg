class Solution {
    public void rotateMatrix(int[][] mat) {
        // code here
        int n = mat.length;

        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Reverse the order of rows
        for (int i = 0; i < n / 2; i++) {
            int[] temp = mat[i];
            mat[i] = mat[n - 1 - i];
            mat[n - 1 - i] = temp;
        }
    }
}