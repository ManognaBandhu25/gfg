class Solution {
    public int maxEdgesToAdd(int V, int[][] edges) {
        int kalai=edges.length;
        int max =(V*(V-1))/2;
        return max-kalai;
    }
}