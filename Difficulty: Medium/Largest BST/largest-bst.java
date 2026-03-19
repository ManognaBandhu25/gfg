// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {

    // Return the size of the largest sub-tree which is also a BST
    
    static class TreeReturnDTO{
        public Integer largestNode;
        public Integer smallestNode;
        public Integer totalSize;
        public boolean isBST;
        
        public TreeReturnDTO(Integer largestNode,Integer smallestNode,Integer totalSize, boolean isBST)
        {
            this.largestNode=largestNode;
            this.smallestNode=smallestNode;
            this.totalSize=totalSize;
            this.isBST=isBST;
        }
    }
    
    private static Integer largestSize=0;
    
    private static boolean isValid(int larger,int smaller,int current)
    {
        return current>larger&&smaller>current;
    }

    private static TreeReturnDTO dfs(Node root)
    {
        if(root==null){
            return new TreeReturnDTO(-1,Integer.MAX_VALUE,0,true);
        }
        
        TreeReturnDTO leftTree=dfs(root.left);
        TreeReturnDTO rightTree=dfs(root.right);
        
        if(leftTree.isBST&&rightTree.isBST)
        {
            if(isValid(leftTree.largestNode,rightTree.smallestNode,root.data))
            {
                
                Integer smallestValue=root.left==null?root.data:leftTree.smallestNode;
                Integer biggestValue=root.right==null?root.data:rightTree.largestNode;
            
                
                largestSize=Math.max(largestSize,rightTree.totalSize+leftTree.totalSize+1);
                
                return new TreeReturnDTO(biggestValue,smallestValue,rightTree.totalSize
                +leftTree.totalSize+1,true);
                
            }
        }
        
        return new TreeReturnDTO(-1,-1,0,false);
    }
    
    
    static int largestBst(Node root) {
        // Write your code here
        
        dfs(root);
        
        int ans=largestSize;
        
        largestSize=0;
        
        return ans;
        
    }
}