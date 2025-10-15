class Solution {
    public int kthSmallest(Node root, int k) {
        // code here
        if(root == null) return -1;
        ArrayList<Integer> arr = new ArrayList<>();
        helper(root,arr);
        if (k > 0 && k <= arr.size()) {
            return arr.get(k - 1);
        }
        return -1; 
        
       
    }
    
    public static void helper(Node root,ArrayList<Integer> arr){
        if(root == null) return;
        
        helper(root.left,arr);
        arr.add(root.data);
        helper(root.right,arr);
    }
}