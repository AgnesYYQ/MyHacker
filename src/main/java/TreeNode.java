public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int item)
    {
        val = item;
        left = right = null;
    }

    public static void printLeafNodes(TreeNode node) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            System.out.printf("%d ", node.val);
        }
        printLeafNodes(node.left);
        printLeafNodes(node.right);
    }
}
