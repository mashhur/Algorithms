package leetcode.may2020Problems;

import java.util.Objects;

public class Cousins {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;
        public TreeNode(int val) {
            this.value = val;
        }
    }

    public boolean areCousins(TreeNode root, int xNode, int yNode) {
      if (Objects.isNull(root)) return false;

      int xDepth = depth(root, xNode, 0);
      int yDepth = depth(root, yNode, 0);
      return yDepth != 0 && xDepth == yDepth;
    }

    private int depth(TreeNode root, int node, int depth) {
      if (Objects.isNull(root)) return 0;
      if (root.value == node) return depth;

      int leftDepth = depth(root.left, node, depth + 1);
      int rightDepth = depth(root.right, node, depth + 1);
      return Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        TreeNode first = new TreeNode(1);
        first.right = new TreeNode(3);
        first.left = new TreeNode(2);
        first.left.left = new TreeNode(4);

        Cousins cousins = new Cousins();
        System.out.println(cousins.areCousins(first, 2, 3));
    }
}
