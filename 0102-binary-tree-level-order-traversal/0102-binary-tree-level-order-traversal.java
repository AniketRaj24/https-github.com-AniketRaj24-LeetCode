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
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue <TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        q.add(root);
        while(!q.isEmpty()){
            int lvlSize = q.size();
            List <Integer> tmp = new ArrayList<>();
            while(lvlSize-- > 0){
                TreeNode t = q.poll();
                tmp.add(t.val);
                if(t.left != null){
                    q.add(t.left);
                }                 
                if(t.right != null){
                    q.add(t.right);
                }
            }
            res.add(new ArrayList<>(tmp));
        }
        return res;
    }
}