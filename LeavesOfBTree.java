/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LeavesOfBTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();

        levels(root, result);
        return result;
    }
    
    //Same as level order traversal, but we start counting level from leaf node
    public int levels(TreeNode t, List<List<Integer>> leavesList){
        
        if(t == null)
            return -1;
        
        int leftHt = levels(t.left, leavesList);
        int rightHt = levels(t.right, leavesList);
        
        int level = 1 + Math.max(leftHt, rightHt);
        
        //We have not added any node for that level
        if(leavesList.size() == level)
            leavesList.add(new ArrayList());
        
        leavesList.get(level).add(t.val);
        
        return level;
    }
}
