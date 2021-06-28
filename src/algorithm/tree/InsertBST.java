package algorithm.tree;

import sun.reflect.generics.tree.Tree;

import java.util.Arrays;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int x) {
        val = x;
        left = new TreeNode();
        right = new TreeNode();
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

/**
 *         5
 *      3      6
 *    2  4       7
 */

public class InsertBST {

    public static void main(String[] args) {

        TreeNode tree = new TreeNode(4);
        tree.left = new TreeNode(2);
        tree.left.left= new TreeNode(1);
        tree.left.right = new TreeNode(3);
        tree.right = new TreeNode(7);

//        tree.left.val = 2;
//        tree.left.left.val = 1;
//        tree.left.right.val = 3;

//        tree.getLeft().setVal(2);
//        tree.getLeft().getLeft().setVal(1);


        insertIntoBST(tree, 5);

        Arrays.asList(tree).stream().forEach(v -> System.out.print(v.toString()));
        System.out.println(" ");

    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            System.out.println("new TreeNode(" + val + ")");
            return new TreeNode(val);
        }

        TreeNode child = null;
        if (val > root.val) {
            System.out.println("right insertIntoBST(" + root.right + ", " + val + ");");
            child = insertIntoBST(root.right, val);
            root.right = child;
        } else {
            System.out.println("left insertIntoBST(" + root.left + ", " + val + ");");
            child = insertIntoBST(root.left, val);
            root.left = child;
        }

        return root;
    }

}
