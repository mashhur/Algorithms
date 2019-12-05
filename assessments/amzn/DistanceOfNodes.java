package assessments.amzn;

class Node {
    int data;
    Node right;
    Node left;
    Node(int data){
        this.data = data;
        right = left = null;
    }
}

public class DistanceOfNodes {

    public static void main(String args[]){
        int[] nArr = {5,6,3,1,2,4};
        int n = 6;
        int node1 = 6;
        int node2 = 4;

        System.out.println(bDistance(nArr, n, node1, node2));
    }

    static Node root;
    public static void InitBinaryTree(int[] values){
        for (int item : values){
            if(root == null) {
                root = new Node(item);
            }
            else {
                Node nCurr = root;
                while (nCurr != null) {
                    if(item > nCurr.data) {
                        if(nCurr.right == null){
                            nCurr.right = new Node(item);
                            break;
                        }
                        else
                            nCurr = nCurr.right;
                    } else {
                        if(nCurr.left == null){
                            nCurr.left = new Node(item);
                            break;
                        }
                        else
                            nCurr = nCurr.left;
                    }
                }
            }
        }
    }

    public static int bDistance(int[] values, int n, int node1, int node2){
        InitBinaryTree(values);

        Node node = findCommonAncestor(root, node1, node2);
        int distLCA = getLevel(root, node.data);
        int dist1 = getLevel(root, node1);
        int dist2 = getLevel(root, node2);

        if(dist1 == -1 || dist2 == -1)
            return -1;

        return dist1 + dist2 - 2 * distLCA;
    }

    private static Node findCommonAncestor(Node root, int node1, int node2) {
        if (root == null)
            return null;
        if (root.data == node1 || root.data == node2)
            return root;

        Node left_lca = findCommonAncestor(root.left, node1, node2);
        Node right_lca = findCommonAncestor(root.right, node1, node2);

        if (left_lca != null && right_lca != null)
            return root;
        return left_lca != null ? left_lca : right_lca;
    }

    private static int getLevel(Node root, int data) {
        if (root == null)
            return -1;
        if(root.data == data)
            return 0;

        int level = getLevel(root.left, data);

        if (level == -1)
            level = getLevel(root.right, data);

        if(level != -1)
            return level + 1;

        return -1;
    }
}