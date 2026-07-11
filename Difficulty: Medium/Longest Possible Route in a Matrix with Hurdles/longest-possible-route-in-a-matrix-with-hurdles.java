class Solution {
    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
        // code here
         if (mat[xs][ys] == 0 || mat[xd][yd] == 0) {

            return -1;

        }

        int n=mat.length,m=mat[0].length;

        boolean[][] visited = new boolean[n][m];

        int[] maxPath = {-1}; // Single-element array to pass by reference

        

        dfs(mat, n, m, xs, ys, xd, yd, visited, 0, maxPath);

        

        return maxPath[0];

    }

    

    private static void dfs(int[][] mat, int n, int m, int r, int c, int xd, int yd, 

                            boolean[][] visited, int currentLength, int[] maxPath) {

        // Base case: destination reached

        if (r == xd && c == yd) {

            maxPath[0] = Math.max(maxPath[0], currentLength);

            return;

        }

        

        // Mark the current cell as visited

        visited[r][c] = true;

        

        // Direction vectors for moving Up, Down, Left, and Right

        int[] dr = {-1, 1, 0, 0};

        int[] dc = {0, 0, -1, 1};

        

        for (int i = 0; i < 4; i++) {

            int nr = r + dr[i];

            int nc = c + dc[i];

            

            // Check boundaries, traversability, and visited status

            if (nr >= 0 && nr < n && nc >= 0 && nc < m && mat[nr][nc] == 1 && !visited[nr][nc]) {

                dfs(mat, n, m, nr, nc, xd, yd, visited, currentLength + 1, maxPath);

            }

        }

        

        // Backtrack: unmark the current cell for other path combinations

        visited[r][c] = false;
    }
}