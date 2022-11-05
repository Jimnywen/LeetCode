import java.util.*;

public class Main {

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

    // lc 102 107
    public List<List<Integer>> bfs(TreeNode root) {
        if (root == null) return new ArrayList<>();
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        deque.offer(root);
        List<Integer> tempArr = new ArrayList<>();
        int size = 1;
        while (!deque.isEmpty()) {

            TreeNode node = deque.poll();
            tempArr.add(node.val);

            if (node.left != null) {
                deque.offer(node.left);
            }
            if (node.right != null) {
                deque.offer(node.right);
            }
            size--;
            if (size == 0) {
                ans.add(new ArrayList<>(tempArr));
                tempArr.clear();
                size = deque.size();
            }
        }
        Collections.reverse(ans);
        return ans;
    }

    public int maxDepth = -1;

    public void dfs(TreeNode node, int depth) {
        if (node == null) return;

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);

        maxDepth = Math.max(depth, maxDepth);
    }

    // lc 104
    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return maxDepth;
    }

    public int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int ans = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            ans++;
        }
        return ans;
    }

    // lc 101
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);

    }

    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;

        // left is null but right isn't null
        if (left == null || right == null) return false;

        if (left.val != right.val) return false;


        boolean left_left = check(left.left, right.right);
        boolean left_right = check(left.right, right.left);
        return left_left && left_right;
    }

    // lc 1662
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (String s1 : word1) {
            sb1.append(s1);
        }
        for (String s2 : word2) {
            sb2.append(s2);
        }
        return sb1.toString().equals(sb2.toString());
    }

    // lc 111
    int minDepth = Integer.MAX_VALUE;

    void dfsFor111(TreeNode node, int depth) {
        if (node == null) return;

        dfsFor111(node.left, depth + 1);
        dfsFor111(node.right, depth + 1);
        if (node.left == null && node.right == null) {
            minDepth = Math.min(minDepth, depth);
        }

    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        dfsFor111(root, 1);
        return minDepth;

    }

    public static void main(String[] args) {
        TreeNode root = arrayToTreeNode(new Integer[]{1, 4, 5, 4, 4, null, 5});
        System.out.println(new Main().maxDepth(root));
//        new Main().bfs(root);
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