class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        boolean lefttoright = true;
        q.add(root);
        while (!q.isEmpty()) {
            int lvlSize = q.size();
            List<Integer> tmp = new ArrayList<>(Collections.nCopies(lvlSize, 0));
            int first = 0;
            int last = lvlSize - 1;
            int count = lvlSize;
            while (count-- > 0) {
                TreeNode t = q.poll();
                if (t.left != null) {
                    q.add(t.left);
                }
                if (t.right != null) {
                    q.add(t.right);
                }
                if (lefttoright) {
                    tmp.set(first, t.val);
                    first++;
                } else {
                    tmp.set(last, t.val);
                    last--;
                }
            }
            res.add(tmp);
            lefttoright = !lefttoright;
        }
        return res;
    }
}