
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
   
    HashMap<Integer, Integer> hash; 
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         int index = postorder.length;
        
        if(inorder == null || postorder ==null){
            return null;
        }
        hash = new HashMap<Integer, Integer>();
        for(int i=0; i< inorder.length; i++){
            hash.put(inorder[i], i);
        }
        
        return  helper(inorder, postorder, postorder.length-1,  0,  inorder.length-1);
    }
    
    private TreeNode helper(int[] inorder, int[] postorder,  int ps_end, int start, int end){
        
        if(start > end || ps_end >= postorder.length)
            return null;
        
        
        TreeNode root = new TreeNode(postorder[ps_end]);
        
        
        int indx = hash.get(postorder[ps_end]);
        
        
        root.left = helper(inorder, postorder, ps_end-1-(end-indx), start, indx-1);
        root.right = helper(inorder, postorder,ps_end-1, indx+1, end);
       
        return root;
        
        
    }
}
// =============================Sum of Root to leaf====================
// Time Complexity : O(n)
// Space Complexity : O(h) h - Height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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

    public int sumNumbers(TreeNode root) {
        
        return helper(root,0);
        
    }
    
    private int helper(TreeNode root, int currSum){
        // base
        if(root == null)
            return 0;
        
        currSum = currSum*10+root.val;
        
        if(root.left == null && root.right == null)
            return currSum;
       
        // logic
        int left = helper(root.left,currSum);
        int right = helper(root.right, currSum);
        return (left + right);
        
    }
}
