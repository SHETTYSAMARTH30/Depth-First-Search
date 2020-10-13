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
class DelNodeBuildForest {
    
    //Time Complexity = O(n + m), where n = number of nodes, m = nodes to delete(hashset creation time)
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        
        //will store rem nodes left in tree
        List<TreeNode> remaining = new ArrayList<>();
        
        //For looking for deleting node values in O(1) time
        Set<Integer> toDelete = new HashSet<>();
        
        for(int i : to_delete){
            
            toDelete.add(i);
        }
        
        dfs(root,toDelete,remaining);
        
        //Since we did not add the root node into the list
        if(!toDelete.contains(root.val)){
            
            remaining.add(root);
        }
        
        return remaining;
    }
    
    public TreeNode dfs(TreeNode node, Set<Integer> toDelete, List<TreeNode> remaining){
        
        if(node == null)
            return null;
        
        node.left = dfs(node.left, toDelete, remaining);
        node.right = dfs(node.right, toDelete, remaining);
        
        //Then we need to delete that particular node
        //Before deleting we add the left and right child to remaining list
        if(toDelete.contains(node.val)){
            
            if(node.left != null){
                
                remaining.add(node.left);
            }
            
            if(node.right != null){
                
                remaining.add(node.right);
            }
            
            //Hence we get a disjoint tree
            return null;
        }
        
        return node;   
        
    }
}
