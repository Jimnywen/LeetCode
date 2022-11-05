import java.util.HashMap;

public class Main {
    HashMap<Integer, Integer> map = new HashMap<>();
    int ans;

    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 1, 1);
        return ans;
    }

    public void dfs(TreeNode node, int depth, int index) {
        if (node == null) return;
        map.putIfAbsent(depth, index);
        ans = Math.max(index - map.get(depth) + 1, ans);
        dfs(node.left, depth + 1, index * 2);
        dfs(node.right, depth + 1, index * 2 + 1);

    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}