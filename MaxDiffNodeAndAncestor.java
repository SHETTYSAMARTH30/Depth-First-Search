/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class MaxDiffNodeAndAncestor {
    
    int maxDiff = 0;
    
    public int maxAncestorDiff(TreeNode root) {
        
        if(root == null)
            return 0;
        
        //We will pass the minimum and maximum value, cuz the maximum diff will always be diff between a number and min/max value. We do not need to find diff between each node and its ancestor (Working is similar to validate a BST)
        
        helper(root, root.val, root.val);
        
        return maxDiff;        
    }
    
    public void helper(TreeNode node, int currMin, int currMax){
        
        if(node != null){
            
            //We find maxDiff between a node and max value and a node and min value. Then if its greater than maxDiff store in result
            int possibleResult = Math.max(Math.abs(node.val - currMin), Math.abs(node.val - currMax));
            
            maxDiff = Math.max(maxDiff, possibleResult);
            
            currMin = Math.min(node.val, currMin);
            currMax = Math.max(node.val, currMax);
            
            helper(node.left, currMin, currMax);
            helper(node.right, currMin, currMax);
        } 
    }
}
