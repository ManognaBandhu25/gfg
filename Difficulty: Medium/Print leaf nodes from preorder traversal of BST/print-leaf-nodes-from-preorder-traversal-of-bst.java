import java.util.*;

class Solution {
    public ArrayList<Integer> leafNodes(int[] preorder) {
        ArrayList<Integer> result = new ArrayList<>();
        findLeaves(preorder, 0, preorder.length - 1, result);
        return result;
    }

    private void findLeaves(int[] preorder, int start, int end, ArrayList<Integer> result) {
        if (start > end) return;

        // If only one node, it's a leaf
        if (start == end) {
            result.add(preorder[start]);
            return;
        }

        int root = preorder[start];
        int idx = start + 1;

        // Find the first node greater than root (right subtree starts)
        while (idx <= end && preorder[idx] < root) {
            idx++;
        }

        // Recursively find in left and right subtree
        findLeaves(preorder, start + 1, idx - 1, result); // Left subtree
        findLeaves(preorder, idx, end, result);          // Right subtree
    }
}
