package trees;

/**
 * Created by mashhur on 2/10/17.
 */

public class CommonAncestor {

    static Node root;

    public static void main(String args[]) {
        int[] nArr = {7, 5, 6, 3, 1, 2, 4};
        int node1 = 6;
        int node2 = 4;

        InitBinaryTree(nArr);
        //System.out.println(getCommonAncestor(root, node1, node2).data);
        System.out.println("Node 1 level: " + (getLevel(root, node1) - 1));
        System.out.println("Node 2 level: " + (getLevel(root, node2) - 1));
    }

    public static void InitBinaryTree(int[] values) {
        for (int item : values) {
            if (root == null) {
                root = new Node(item);
            } else {
                Node nCurr = root;
                while (nCurr != null) {
                    if (item > nCurr.data) {
                        if (nCurr.right == null) {
                            nCurr.right = new Node(item);
                            break;
                        } else
                            nCurr = nCurr.right;
                    } else {
                        if (nCurr.left == null) {
                            nCurr.left = new Node(item);
                            break;
                        } else
                            nCurr = nCurr.left;
                    }
                }
            }
        }
    }

    private static Node getCommonAncestor(Node nCurr, int node1, int node2) {
        if (nCurr == null) return null;
        if (nCurr.data == node1 || nCurr.data == node2)
            return nCurr;

        Node nLeft = getCommonAncestor(nCurr.left, node1, node2);
        Node nRight = getCommonAncestor(nCurr.right, node1, node2);

        if (nLeft != null && nRight != null)
            return nCurr;
        return nLeft != null ? nLeft : nRight;
    }

    // O(Log2(N)) solution
    private static int getLevel(Node nCurr, int node) {
        if (nCurr == null) return 0;
        System.out.println(nCurr.data);
        if (nCurr.data == node) return 1;
        int nLevel = 1;
        if (node <= nCurr.data)
            nLevel += getLevel(nCurr.left, node);
        else
            nLevel += getLevel(nCurr.right, node);


        return nLevel;
    }
}
