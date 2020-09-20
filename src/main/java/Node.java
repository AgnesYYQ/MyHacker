import java.util.*;
import java.io.*;

class Node {
    Node left, right;
    int data;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution1 {
    static ArrayList<ArrayList<Integer>> levelData = new ArrayList<>();

    public static int getHeight(Node root) {
        if (root.left == null && root.right == null) {
            return 0;
        }
        int leftHeight = 0, rightHeight = 0;
        if (root.left != null) {
            leftHeight = 1 + getHeight(root.left);
        }
        if (root.right != null) {
            rightHeight = 1 + getHeight(root.right);
        }
        return Math.max(leftHeight, rightHeight);
    }

    static void printLevelOrder(Node node) {
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(node);
        while (! queue.isEmpty()) {
            Node tmpNode = queue.poll();
            System.out.print(tmpNode.data + " ");
            if (tmpNode.left != null) queue.add(tmpNode.left);
            if (tmpNode.right != null) queue.add(tmpNode.right);
        }
    }

    static void levelPrint(Node root, int level) {
        if (root == null) return;
        if (level == 0) {
            System.out.print(root.data + " ");
        } else {
            levelPrint(root.left, level - 1);
            levelPrint(root.right, level - 1);
        }
    }

    static void levelOrder(Node root){
        buildLevelData(root, 0);
        ArrayList<Integer> result = new ArrayList<>();
        for (ArrayList<Integer> data : levelData) {
            result.addAll(data);
        }
        for (int s : result) {
            System.out.print(s + " ");
        }
    }

    static void buildLevelData(Node node, int level) {
        if (node == null) return;
        if (levelData.size() - 1 >= level) {
            ArrayList<Integer> data = levelData.get(level);
            data.add(node.data);
            levelData.set(level, data);
        } else {
            ArrayList<Integer> data = new ArrayList<>();
            data.add(node.data);
            levelData.add(data);
        }
        buildLevelData(node.left, level + 1);
        buildLevelData(node.right, level + 1);
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    static Node uniq  = null;
    static ArrayList<Integer> nums = new ArrayList<>();
    public static void removeDuplicates(Node head) {
        //Write your code here
        if (head == null || nums.contains(head.data)) return;

        uniq = insert(uniq, head.data);
        nums.add(head.data);

        removeDuplicates(head.left);
        removeDuplicates(head.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Node root = null;
        while (num-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }

        levelOrder(root);

        int height = getHeight(root);
        System.out.println("\nHeight: " + height);
        for (int i = 0; i <= height; i++) {
            levelPrint(root, i);
        }

        System.out.println("\nPrint Level Order: ");
        printLevelOrder(root);

        System.out.println("\nRemoved Duplicates: ");
        removeDuplicates(root);
        printLevelOrder(uniq);
    }
}