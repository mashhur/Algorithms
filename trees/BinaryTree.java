package trees;// Java program to construct BST from given preorder traversal

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// A binary tree node
class TreeNode {

    int data;
    TreeNode left, right;

    TreeNode(int d) {
        data = d;
        left = right = null;
    }
}

class BinaryTree {

    // A utility function to print inorder traversal of a Binary Tree
    private static void printInorder(TreeNode node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    private static void preOrder(TreeNode root) {
        if (root != null) {
            //Visit the node by Printing the node data
            System.out.printf("%d ", root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    private static void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            //Visit the node by Printing the node data
            System.out.printf("%d ", root.data);
        }
    }

    private static void LevelOrderTraversal(TreeNode startNode) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(startNode);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            System.out.printf("%d ", tempNode.data);
            if (tempNode.left != null)
                queue.add(tempNode.left);
            if (tempNode.right != null)
                queue.add(tempNode.right);
        }
    }

    private static int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // lowest common ancestor
    private static TreeNode lca(TreeNode node, int n1, int n2) {
        if (node == null) {
            return null;
        }

        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (node.data > n1 && node.data > n2) {
            return lca(node.left, n1, n2);
        }

        // If both n1 and n2 are greater than root, then LCA lies in right
        if (node.data < n1 && node.data < n2) {
            return lca(node.right, n1, n2);
        }

        return node;
    }

    // Driver program to test above functions
    public static void UnitTest() {
        BinaryTree tree = new BinaryTree();
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};

        int size = pre.length;
        TreeNode root = tree.constructTree(pre, size);
        System.out.println("Inorder traversal of the constructed tree is ");
        //tree.printInorder(root);

        System.out.println("----- Pre order -----");
        preOrder(root);
        System.out.println();
        System.out.println("----- Post order -----");
        postOrder(root);

        System.out.println();
        System.out.println("----- In order -----");
        printInorder(root);

        System.out.println();
        System.out.println("----- Level order ------");
        LevelOrderTraversal(root);

        System.out.println();
        System.out.println("----- Tree height ------");
        System.out.print(height(root));

        System.out.println();
        System.out.println("----- Lowest Common Ancestor ------");
        System.out.println(lca(root, 7, 5).data);
    }

    public static void main(String args[]) {
        BinaryTree btree = new BinaryTree();
        btree.UnitTest();
    }

    // The main function that constructs BST from pre[]
    private TreeNode constructTree(int pre[], int size) {

        // The first element of pre[] is always root
        TreeNode root = new TreeNode(pre[0]);

        Stack<TreeNode> s = new Stack<>();

        // Push root
        s.push(root);

        // Iterate through rest of the size-1 items of given preorder array
        for (int i = 1; i < size; ++i) {
            TreeNode temp = null;

            /* Keep on popping while the next value is greater than
             stack's top value. */
            while (!s.isEmpty() && pre[i] > s.peek().data) {
                temp = s.pop();
            }

            // Make this greater value as the right child and push it to the stack
            if (temp != null) {
                temp.right = new TreeNode(pre[i]);
                s.push(temp.right);
            }

            // If the next value is less than the stack's top value, make this value
            // as the left child of the stack's top node. Push the new node to stack
            else {
                temp = s.peek();
                temp.left = new TreeNode(pre[i]);
                s.push(temp.left);
            }
        }

        return root;
    }

}