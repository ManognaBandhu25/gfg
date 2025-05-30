class Solution {

    // Wrapper class to keep track of maximum length and sum
    static class Result {
        int maxSum = 0;
        int maxLen = 0;
    }

    public int sumOfLongRootToLeafPath(Node root) {
        Result res = new Result();
        dfs(root, 0, 0, res);
        return res.maxSum;
    }

    // Helper method to perform DFS
    private void dfs(Node node, int currSum, int currLen, Result res) {
        if (node == null) return;

        currSum += node.data;
        currLen++;

        // If it's a leaf node
        if (node.left == null && node.right == null) {
            if (currLen > res.maxLen) {
                res.maxLen = currLen;
                res.maxSum = currSum;
            } else if (currLen == res.maxLen) {
                res.maxSum = Math.max(res.maxSum, currSum);
            }
            return;
        }

        // Recur for left and right
        dfs(node.left, currSum, currLen, res);
        dfs(node.right, currSum, currLen, res);
    }
}
