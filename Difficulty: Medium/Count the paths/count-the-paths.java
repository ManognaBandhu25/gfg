class Solution {
    public int countPaths(int[][] edges, int V, int src, int dest) {
        // Step 1: Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        // Step 2: Create memo array to store intermediate results
        int[] dp = new int[V];
        Arrays.fill(dp, -1);

        // Step 3: Run DFS with memoization
        return dfs(src, dest, adj, dp);
    }

    private int dfs(int current, int dest, List<List<Integer>> adj, int[] dp) {
        if (current == dest) return 1;
        if (dp[current] != -1) return dp[current];

        int totalPaths = 0;
        for (int neighbor : adj.get(current)) {
            totalPaths += dfs(neighbor, dest, adj, dp);
        }

        dp[current] = totalPaths;
        return totalPaths;
    }
}
