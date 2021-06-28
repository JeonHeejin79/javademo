package algorithm.tree;

/**
 * Range Sum of BST
 * Given the root node of a binary search tree,
 * return the sum of values of all nodes with value between L and R (inclusive)
 *
 * The binary search tree is guaranteed to have unique values.
 *
 * Input: root = [10, 7, 15, 3, 7, null, 18], L = 7, R = 15
 * Output = 32
 *
 */

class TreeNode4 {
    int val;
    TreeNode4 left;
    TreeNode4 right;
    TreeNode4(int x) { val = x; }
}
public class rangeSumBST {
    public static void main(String[] args) {

    }

    /**
     * 1. root.val < L
     * 2. root.val > R
     * 3. L <= root.val <= R -> 왼쪽 섭트리 + 내 값 + 오른쪽 섭트리
     * 1 2 [3 4 5 6 7 8 9 10] 11 12
     */
    public static int exRangeSumBST(TreeNode4 root, int L, int R) {

        if (root == null) {
            return 0;
        } else if (root.val < L) {
            return exRangeSumBST(root.right, L, R);
        } else if (root.val > R) {
            return exRangeSumBST(root.left, L, R);
        } else {
            return exRangeSumBST(root.left, L, R) + root.val +
            exRangeSumBST(root.right, L, R);
        }
    }
}
