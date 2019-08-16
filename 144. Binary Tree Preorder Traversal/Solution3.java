/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution3 {
    public List<Integer> preorderTraversal(TreeNode root) {
        return preorderTraversal3(root);
    }
    
    /*
    method 3:
    Runtime: 1 ms, faster than 61.05% of Java online submissions for Binary Tree Preorder Traversal.
    Memory Usage: 34.8 MB, less than 100.00% of Java online submissions for Binary Tree Preorder Traversal.
    */
    private List<Integer> preorderTraversal3(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ret = new LinkedList<>();
        
        TreeNode cur = root;
        if(cur != null) stack.push(cur);
        else return ret;
        
        while(!stack.empty())
        {
            TreeNode top = stack.pop();
            ret.add(top.val);
            
            if(top.right != null) stack.push(top.right);
            if(top.left != null) stack.push(top.left);
        }
        return ret;
    }
    
    
}
