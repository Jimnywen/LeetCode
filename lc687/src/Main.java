import java.util.LinkedList;
import java.util.Queue;

public class Main {
    int sum = 0;

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
        return Math.max(l, r);// 求的是一条路径 若返回 l+r 则为两条分支两个不同路径
    }


    public static TreeNode arrayToTreeNode(Integer[] array) {
        if (array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;
        for (int i = 1; i < array.length; i++) {
            TreeNode node = queue.peek();
            if (isLeft) {
                if (array[i] != null) {
                    node.left = new TreeNode(array[i]);
                    queue.offer(node.left);
                }
                isLeft = false;
            } else {
                if (array[i] != null) {
                    node.right = new TreeNode(array[i]);
                    queue.offer(node.right);
                }
                queue.poll();
                isLeft = true;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = arrayToTreeNode(new Integer[]{1, 4, 5, 4, 4, null, 5});

        Main t1 = new Main();
        t1.longestUnivaluePath(root);
        System.out.println(t1.sum);
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