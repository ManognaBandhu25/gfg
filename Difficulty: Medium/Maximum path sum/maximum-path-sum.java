class Solution {
    int oMax;
    int findMaxSum(Node node) {
        oMax = Integer.MIN_VALUE;
        helper(node);
        return oMax;
    }
    
    public int helper(Node root) {
        if (root == null) return 0;

        int left = Math.max(0, helper(root.left));  // ignore negative paths
        int right = Math.max(0, helper(root.right));

        int currentMaxPath = root.data + left + right;

        oMax = Math.max(oMax, currentMaxPath);

        // return max one-side path to parent
        return root.data + Math.max(left, right);
    }
}