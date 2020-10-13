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
class DistributeCoins {
    
    int ans;
    
    public int distributeCoins(TreeNode root) {

        dfs(root);
        return ans;
    }
    
    public int dfs(TreeNode node){
        
        if(node == null)
            return 0;
        
        //We will get number of excess coins both from left and right
        int left = dfs(node.left);
        int right = dfs(node.right);
        
        //The sum of the number of excess coins we get at each node is the total number of moves
        ans += Math.abs(left) + Math.abs(right);
        
        //We keep just 1 coin and then return all the other coins that we have (coin at that node + left subtree coins + right subtrees coin)
        return node.val + left + right - 1;
        
    }
}
