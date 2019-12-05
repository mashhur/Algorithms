package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
// Input: [3,9,20,null,null,15,7]
// Output: [[3],[20,9],[15,7]]

public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Stack<TreeNode> currentLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        List<Integer> list = new ArrayList<>();

        boolean leftToRight = true;

        currentLevel.push(root);
        while (currentLevel.isEmpty() == false) {
            TreeNode node = currentLevel.pop();
            list.add(node.val);

            if (leftToRight) {
                if (node.left != null)
                    nextLevel.push(node.left);
                if (node.right != null)
                    nextLevel.push(node.right);
            } else {
                if (node.right != null)
                    nextLevel.push(node.right);
                if (node.left != null)
                    nextLevel.push(node.left);
            }

            if (currentLevel.isEmpty()) {
                currentLevel = nextLevel;
                nextLevel = new Stack<>();
                leftToRight = !leftToRight;
                result.add(list);
                list = new ArrayList<>();
            }
        }

        return result;
    }
}
