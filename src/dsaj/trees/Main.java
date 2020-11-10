
package dsaj.trees;// Java program to demonstrate insert, search and delete operation in binary search tree

public class Main {
    /* Class containing left and right child of current node and key value*/
    class Node {
        String key;
        Node left, right;

        public Node(String item) {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    Main() {
        root = null;
    }

    // This method mainly calls insertRec()
    void insert(String key) {
        root = insertRec(root, key);
    }

    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, String key) {

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }
        /* Otherwise, recur down the tree */
        int compare = key.compareToIgnoreCase(root.key);
        if (compare<0)
            root.left = insertRec(root.left, key);
        else if (compare>0)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    // A utility function to search a given key in BST
    public Node search(Node root, String key)
    {
        if (root == null) {
            return root;
        }
        int compare = key.compareToIgnoreCase(root.key);
        // Base Cases: root is null or key is present at root
        if (compare==0)
            return root;

        // val is greater than root's key
        if (compare<0)
            return search(root.left, key);

        // val is less than root's key
        return search(root.right, key);
    }
    public boolean contains(String key){
        Node foundNode = search(root,key);
        if (foundNode == null)
            return false;
        else
            return true;
    }

    // This method mainly calls deleteRec()
    void delete(String key)
    {
        root = deleteRec(root, key);
    }

    /* A recursive function to insert a new key in BST */
    Node deleteRec(Node root, String key)
    {
        /* Base Case: If the tree is empty */
        if (root == null)  return root;
        int compare = key.compareToIgnoreCase(root.key);
        /* Otherwise, recur down the tree */
        if (compare<0)
            root.left = deleteRec(root.left, key);
        else if (compare>0)
            root.right = deleteRec(root.right, key);

            // if key is same as root's key, then This is the node
            // to be deleted
        else
        {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    String minValue(Node root)
    {
        String minv = root.key;
        while (root.left != null)
        {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    // function to print level order traversal of tree
    void levelorder()
    {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++)
            printGivenLevel(root, i);
    }

    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int height(Node root)
    {
        if (root == null)
            return 0;
        else
        {
            // compute  height of each subtree 
            int lheight = height(root.left);
            int rheight = height(root.right);

            // use the larger one 
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1);
        }
    }

    // Print nodes at the given level 
    void printGivenLevel (Node root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.key+ " ");
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }

    // This method mainly calls InorderRec()
    void inorder()  {
        inorderRec(root);
    }
    // A utility function to do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key+ " ");
            inorderRec(root.right);
        }
    }

    // This method mainly calls preorderRec()
    void preorder()  {
        preorderRec(root);
    }
    // A utility function to do preorder traversal of BST
    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
    }

    // This method mainly calls postorderRec()
    void postorder()  {
        postorderRec(root);
    }
    // A utility function to do postorder traversal of BST
    void postorderRec(Node root) {
        //TODO Write a recursive function which prints the BST in postfix order.
    }


    // Driver Program to test above functions
    public static void main(String[] args) {
        dsaj.trees.Main tree = new dsaj.trees.Main();

        tree.insert("cucumber");
        tree.insert("apple");
        tree.insert("orange");
        tree.insert("pear");
        tree.insert("banana");
        tree.insert("peach");
        tree.insert("strawberry");
        tree.insert("grape");
        System.out.println("Level order traversal of the given tree:");
        // print level order traversal of the BST
        tree.levelorder();
        System.out.println("\nInorder traversal of the given tree:");
        // print inorder traversal of the BST
        tree.inorder();
        //TODO print preorder traversal of the BST
        //TODO print postorder traversal of the BST
        System.out.println("\n\"peach\" is in this tree: "+tree.contains("peach"));
        System.out.println("\nDelete peach");
        tree.delete("peach");
        System.out.println("Level order traversal of the modified tree:");
        tree.levelorder();
        System.out.println("\nInorder traversal of the modified tree:");
        tree.inorder();
        //TODO print preorder traversal of the BST
        //TODO print postorder traversal of the BST
        System.out.println("\n\"peach\" is in this tree: "+tree.contains("peach"));
        System.out.println("\nDelete banana");
        tree.delete("banana");
        System.out.println("Level order traversal of the modified tree:");
        tree.levelorder();
        System.out.println("\nInorder traversal of the modified tree:");
        tree.inorder();
        //TODO print preorder traversal of the BST
        //TODO print postorder traversal of the BST
        System.out.println("\nDelete apple");
        tree.delete("apple");
        System.out.println("Level order traversal of the modified tree:");
        tree.levelorder();
        System.out.println("\nInorder traversal of the modified tree:");
        tree.inorder();
        //TODO print preorder traversal of the BST
        //TODO print postorder traversal of the BST
    }

}