class Solution:
    def dfs(self, u, adj, vis):
        vis[u] = True
        for v in adj[u]:
            if not vis[v]:
                self.dfs(v, adj, vis)

    def findMotherVertex(self, V, edges):
        # Step 1: Build adjacency list
        adj = [[] for _ in range(V)]
        for u, v in edges:
            adj[u].append(v)

        # Step 2: Find candidate (last finished in DFS)
        vis = [False] * V
        candidate = -1
        for i in range(V):
            if not vis[i]:
                self.dfs(i, adj, vis)
                candidate = i

        # Step 3: Verify candidate
        vis = [False] * V
        self.dfs(candidate, adj, vis)
        if not all(vis):
            return -1

        # Step 4: If multiple, return smallest
        ans = candidate
        for i in range(V):
            vis = [False] * V
            self.dfs(i, adj, vis)
            if all(vis):
                ans = min(ans, i)

        return ans