package DataStructures.Tree;

/**
 * Binary Search DataStructures.LinkedList.LinkedList.LinkedList.Tree (BST) Implementation in Java
 * A BST is a binary tree where:
 * - Left subtree contains values less than the node
 * - Right subtree contains values greater than the node
 * - No duplicate values (typically)
 */

public class BSTImplementation {

    private Node root;

    // Constructor
    public BSTImplementation() {
        this.root = null;
    }

    // ==================== INSERT OPERATION ====================
    /**
     * Insert a value into the BST
     * Time Complexity: O(log n) average, O(n) worst case (skewed tree)
     * Space Complexity: O(log n) due to recursion stack
     */
    public void insert(int value) {
        root = insertHelper(root, value);
    }

    private Node insertHelper(Node node, int value) {
        // Base case: if tree is empty, create new node
        if (node == null) {
            return new Node(value);
        }

        // If value is less than current node, go left
        if (value < node.value) {
            node.left = insertHelper(node.left, value);
        }
        // If value is greater than current node, go right
        else if (value > node.value) {
            node.right = insertHelper(node.right, value);
        }
        // If value equals node value, it's a duplicate - ignore it

        return node;
    }

    // ==================== SEARCH OPERATION ====================
    /**
     * Search for a value in the BST
     * Time Complexity: O(log n) average, O(n) worst case
     * Space Complexity: O(1) iterative, O(log n) recursive
     */
    public boolean search(int value) {
        return searchHelper(root, value);
    }

    private boolean searchHelper(Node node, int value) {
        // Base case: reached a null node
        if (node == null) {
            return false;
        }

        // If value matches current node
        if (value == node.value) {
            return true;
        }

        // If value is less, search left
        if (value < node.value) {
            return searchHelper(node.left, value);
        }

        // If value is greater, search right
        return searchHelper(node.right, value);
    }

    // ==================== DELETION OPERATION ====================
    /**
     * Delete a value from the BST
     * Three cases:
     * 1. Node is a leaf (no children) - simply remove it
     * 2. Node has one child - replace with that child
     * 3. Node has two children - find inorder successor (smallest in right subtree)
     *    and replace node value with successor value, then delete successor
     * Time Complexity: O(log n) average, O(n) worst case
     */
    public void delete(int value) {
        root = deleteHelper(root, value);
    }

    private Node deleteHelper(Node node, int value) {
        // Base case: tree is empty
        if (node == null) {
            return null;
        }

        // Value to delete is in left subtree
        if (value < node.value) {
            node.left = deleteHelper(node.left, value);
        }
        // Value to delete is in right subtree
        else if (value > node.value) {
            node.right = deleteHelper(node.right, value);
        }
        // Found the node to delete
        else {
            // Case 1: Node is a leaf (no children)
            if (node.left == null && node.right == null) {
                return null;
            }

            // Case 2: Node has only right child
            if (node.left == null) {
                return node.right;
            }

            // Case 2: Node has only left child
            if (node.right == null) {
                return node.left;
            }

            // Case 3: Node has both children
            // Find the inorder successor (smallest value in right subtree)
            Node successor = findMin(node.right);
            // Replace current node's value with successor's value
            node.value = successor.value;
            // Delete the successor node (which has at most one child)
            node.right = deleteHelper(node.right, successor.value);
        }

        return node;
    }

    // Helper method to find minimum value in a subtree
    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Helper method to find maximum value in a subtree
    private Node findMax(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    // ==================== TRAVERSAL OPERATIONS ====================

    /**
     * INORDER Traversal: Left -> Node -> Right
     * Produces values in ASCENDING order
     * Used when you need sorted output
     * Time Complexity: O(n)
     */
    public void inorderTraversal() {
        System.out.print("Inorder (Sorted): ");
        inorderHelper(root);
        System.out.println();
    }

    private void inorderHelper(Node node) {
        if (node == null) return;

        inorderHelper(node.left);           // Left
        System.out.print(node.value + " "); // Node
        inorderHelper(node.right);          // Right
    }

    /**
     * PREORDER Traversal: Node -> Left -> Right
     * Useful for creating a copy of the tree
     * Useful for prefix expression evaluation
     * Time Complexity: O(n)
     */
    public void preorderTraversal() {
        System.out.print("Preorder: ");
        preorderHelper(root);
        System.out.println();
    }

    private void preorderHelper(Node node) {
        if (node == null) return;

        System.out.print(node.value + " "); // Node
        preorderHelper(node.left);          // Left
        preorderHelper(node.right);         // Right
    }

    /**
     * POSTORDER Traversal: Left -> Right -> Node
     * Useful for deleting the tree
     * Useful for postfix expression evaluation
     * Time Complexity: O(n)
     */
    public void postorderTraversal() {
        System.out.print("Postorder: ");
        postorderHelper(root);
        System.out.println();
    }

    private void postorderHelper(Node node) {
        if (node == null) return;

        postorderHelper(node.left);         // Left
        postorderHelper(node.right);        // Right
        System.out.print(node.value + " "); // Node
    }

    /**
     * LEVEL ORDER Traversal (BFS): Process nodes level by level
     * Useful for finding closest element
     * Time Complexity: O(n)
     * Space Complexity: O(width of tree)
     */
    public void levelOrderTraversal() {
        if (root == null) return;

        System.out.print("Level Order: ");
        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            System.out.print(current.value + " ");

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        System.out.println();
    }

    // ==================== UTILITY METHODS ====================

    /**
     * Get the height of the tree
     * Height is the number of edges in the longest path from root to leaf
     * Time Complexity: O(n)
     */
    public int getHeight() {
        return getHeightHelper(root);
    }

    private int getHeightHelper(Node node) {
        if (node == null) return -1;

        int leftHeight = getHeightHelper(node.left);
        int rightHeight = getHeightHelper(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    /**
     * Check if the tree is balanced
     * A balanced BST has height difference <= 1 at every node
     * Time Complexity: O(n)
     */
    public boolean isBalanced() {
        return isBalancedHelper(root).isBalanced;
    }

    private BalanceInfo isBalancedHelper(Node node) {
        if (node == null) {
            return new BalanceInfo(true, -1);
        }

        BalanceInfo leftInfo = isBalancedHelper(node.left);
        if (!leftInfo.isBalanced) return new BalanceInfo(false, 0);

        BalanceInfo rightInfo = isBalancedHelper(node.right);
        if (!rightInfo.isBalanced) return new BalanceInfo(false, 0);

        int heightDiff = Math.abs(leftInfo.height - rightInfo.height);
        boolean balanced = heightDiff <= 1;
        int height = 1 + Math.max(leftInfo.height, rightInfo.height);

        return new BalanceInfo(balanced, height);
    }

    // Helper class for balance checking
    private class BalanceInfo {
        boolean isBalanced;
        int height;

        BalanceInfo(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    /**
     * Find Lowest Common Ancestor (LCA) of two values
     * Time Complexity: O(log n) average, O(n) worst case
     */
    public Integer findLCA(int value1, int value2) {
        Node lca = findLCAHelper(root, value1, value2);
        return lca == null ? null : lca.value;
    }

    private Node findLCAHelper(Node node, int value1, int value2) {
        if (node == null) return null;

        // Both values are in left subtree
        if (value1 < node.value && value2 < node.value) {
            return findLCAHelper(node.left, value1, value2);
        }

        // Both values are in right subtree
        if (value1 > node.value && value2 > node.value) {
            return findLCAHelper(node.right, value1, value2);
        }

        // Current node is the LCA
        return node;
    }

    // ==================== DEMO ====================

    public static void main(String[] args) {
        BSTImplementation bst = new BSTImplementation();

        System.out.println("=== Inserting values: 50, 30, 70, 20, 40, 60, 80 ===");
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int val : values) {
            bst.insert(val);
        }

        System.out.println("\n=== DataStructures.LinkedList.LinkedList.LinkedList.Tree Traversals ===");
        bst.inorderTraversal();
        bst.preorderTraversal();
        bst.postorderTraversal();
        bst.levelOrderTraversal();

        System.out.println("\n=== Search Operations ===");
        System.out.println("Search 40: " + bst.search(40));
        System.out.println("Search 100: " + bst.search(100));

        System.out.println("\n=== DataStructures.LinkedList.LinkedList.LinkedList.Tree Properties ===");
        System.out.println("Height of tree: " + bst.getHeight());
        System.out.println("Is tree balanced: " + bst.isBalanced());

        System.out.println("\n=== LCA (Lowest Common Ancestor) ===");
        System.out.println("LCA of 20 and 40: " + bst.findLCA(20, 40));
        System.out.println("LCA of 20 and 60: " + bst.findLCA(20, 60));

        System.out.println("\n=== Deletion ===");
        System.out.println("Deleting 20 (leaf node)");
        bst.delete(20);
        bst.inorderTraversal();

        System.out.println("Deleting 30 (node with two children)");
        bst.delete(30);
        bst.inorderTraversal();

        System.out.println("Deleting 50 (root node)");
        bst.delete(50);
        bst.inorderTraversal();
    }
}