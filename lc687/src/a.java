public class a {
    int sum=0;

    public int longestUnivaluePath(TreeNode root) {

        dfs(root);
        return sum;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftSum = dfs(node.left);
        int rightSum = dfs(node.right);
        int l = 0, r = 0;
        if (node.left != null && node.val == node.left.val) {
            l = leftSum + 1;
        }
        if (node.right != null && node.val == node.right.val) {
            r = rightSum + 1;
        }
        sum = Math.max(sum, l + r);
        return Math.max(l, r);
    }

}
