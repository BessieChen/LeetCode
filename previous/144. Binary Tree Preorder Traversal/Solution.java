/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        return preorderTraversal3(root);
    }
    
    /*
    method 1:
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Preorder Traversal.
    Memory Usage: 34.9 MB, less than 100.00% of Java online submissions for Binary Tree Preorder Traversal.
    */
    private List<Integer> preorderTraversal1(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        return preorderTraversal1_Recur(list, root);
    }
    
    private List<Integer> preorderTraversal1_Recur(List<Integer> list, TreeNode root)
    {
        if(root != null)
        {
            list.add(root.val);
            preorderTraversal1_Recur(list, root.left);
            preorderTraversal1_Recur(list, root.right);
        }
        return list;
    }
    
    
}
