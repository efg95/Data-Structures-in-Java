/*
* EDITTED FOR HOMEWORK BY ECCLESIASTES GAN
* UNI: EFG2123
*/
import java.util.LinkedList;
import java.util.List;

// AvlTree class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x (unimplemented)
// boolean contains( x )  --> Return true if x is present
// boolean remove( x )    --> Return true if x was present
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print tree in sorted order
// ******************ERRORS********************************
// Throws UnderflowException as appropriate
/**
 * Implements an AVL tree. Note that all "matching" is based on the compareTo
 * method.
 *
 * @author Mark Allen Weiss
 */
public class AvlTree {

    /**
     * Construct the tree.
     */
    public AvlTree() {
        root = null;
    }

    // You could say this is a code not only to find a word, but find whether it exists inside the tree already
    // if it doesnt it returns null so that I can insert the word into the tree, otherwise it returns the word itself
    // helper method that makes everything work
    private AvlNode LocateWords(String word, AvlNode nodeY) {
        while (nodeY != null) {//this while loop will keep going till nodeY is null or if there is a match,
        	//whereby it will return the matched word
            int result = word.compareTo(nodeY.element);

            if (result < 0) {

                nodeY = nodeY.left;

            } else if (result > 0) {

                nodeY = nodeY.right;


            } else {

                return nodeY;

            }
        }

        return null;   // No match
    }

    // Add a new word or new line number in the tree
    public void indexWord(String word, int line) {
    	/* create an AvlNode node that gets assigned the word element
    	 * and the existing root element, the root is null if it is the first string element to enter
    	 * the code
    	 */
        AvlNode node = LocateWords(word, root);//checks whether the word already exists inside the AVL tree
        //if a repetition of the word exists, ignores the below if statement
        //if the word does not exists adds it to the tree
        if (node == null) {
            insert(word);//inserts the word to the node location which was found to be null
        }
        /*
         * this line of code gets called no matter what, because after inserting the word into the tree
         * we still need to append the line number to the word so after we insert the word we call
         * the method LocateWords and append the number to it; repetition words come here straight.
         */
        node = LocateWords(word, root);
      //line of code that checks if a word appears on the same line twice, it should only have one entry in the list
      //for that line
        if(node.lineNumbers.contains(line)){
        	return;
        }else
        node.lineNumbers.add(line);//appends the line number location linked list to the node
    }

    // Return the list of line numbers of a word
    public List getLinesForWord(String word) {
        AvlNode node = LocateWords(word, root);//finds if there is this word in the tree
        //if the node == null then the word does not exists, thus the following if code applies.
        if (node == null) {
            return null;
        }

        return node.lineNumbers;//return the linked list associated with the word in that node.
    }

    // Print out unique words in the AVL tree
    public void printIndex() {
        printIndex(root);
    }

    // Print out unique words in AVL
    private void printIndex(AvlNode currentNode) {
        if (currentNode == null) {
            return;
        }

        System.out.println(currentNode.element + " at line number(s) " + currentNode.lineNumbers);
        /*
         * after printing out the root node
         * recursively calls the left and right child of the root
         * which gets executed until currentNode == null
         */
        printIndex(currentNode.left);
        printIndex(currentNode.right);
    }

    /**
     * Insert into the tree; duplicates are ignored.
     *
     * @param x the item to insert.
     */
    public void insert(String x) {
        root = insert(x, root);
    }

    /**
     * Remove from the tree. Nothing is done if x is not found.
     *
     * @param x the item to remove.
     */
    public void remove(String x) {
        root = remove(x, root);
    }

    /**
     * Internal method to remove from a subtree.
     *
     * @param x the item to remove.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private AvlNode remove(String x, AvlNode t) {
        if (t == null) {
            return t;   // Item not found; do nothing
        }
        int compareResult = x.compareTo(t.element);

        if (compareResult < 0) {
            t.left = remove(x, t.left);
        } else if (compareResult > 0) {
            t.right = remove(x, t.right);
        } else if (t.left != null && t.right != null) // Two children
        {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else {
            t = (t.left != null) ? t.left : t.right;
        }
        return balance(t);
    }

    /**
     * Find the smallest item in the tree.
     *
     * @return smallest item or null if empty.
     */
    public String findMin() {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return findMin(root).element;
    }

    /**
     * Find the largest item in the tree.
     *
     * @return the largest item of null if empty.
     */
    public String findMax() {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return findMax(root).element;
    }

    /**
     * Find an item in the tree.
     *
     * @param x the item to search for.
     * @return true if x is found.
     */
    public boolean contains(String x) {
        return contains(x, root);
    }

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty() {
        root = null;
    }

    /**
     * Test if the tree is logically empty.
     *
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Print the tree contents in sorted order.
     */
    public void printTree() {
        if (isEmpty()) {
            System.out.println("Empty tree");
        } else {
            printTree(root);
        }
    }

    private static final int ALLOWED_IMBALANCE = 1;

    // Assume t is either balanced or within one of being balanced
    private AvlNode balance(AvlNode t) {
        if (t == null) {
            return t;
        }

        if (height(t.left) - height(t.right) > ALLOWED_IMBALANCE) {
            if (height(t.left.left) >= height(t.left.right)) {
                t = rotateWithLeftChild(t);
            } else {
                t = doubleWithLeftChild(t);
            }
        } else if (height(t.right) - height(t.left) > ALLOWED_IMBALANCE) {
            if (height(t.right.right) >= height(t.right.left)) {
                t = rotateWithRightChild(t);
            } else {
                t = doubleWithRightChild(t);
            }
        }

        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }

    public void checkBalance() {
        checkBalance(root);
    }

    private int checkBalance(AvlNode t) {
        if (t == null) {
            return -1;
        }

        if (t != null) {
            int hl = checkBalance(t.left);
            int hr = checkBalance(t.right);
            if (Math.abs(height(t.left) - height(t.right)) > 1
                    || height(t.left) != hl || height(t.right) != hr) {
                System.out.println("OOPS!!");
            }
        }

        return height(t);
    }

    /**
     * Internal method to insert into a subtree.
     *
     * @param x the item to insert.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private AvlNode insert(String x, AvlNode t) {
        if (t == null) {
            return new AvlNode(x, null, null);
        }

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0) {
            t.left = insert(x, t.left);
        } else if (compareResult > 0) {
            t.right = insert(x, t.right);
        } else
            ;  // Duplicate; do nothing
        return balance(t);
    }

    /**
     * Internal method to find the smallest item in a subtree.
     *
     * @param t the node that roots the tree.
     * @return node containing the smallest item.
     */
    private AvlNode findMin(AvlNode t) {
        if (t == null) {
            return t;
        }

        while (t.left != null) {
            t = t.left;
        }
        return t;
    }

    /**
     * Internal method to find the largest item in a subtree.
     *
     * @param t the node that roots the tree.
     * @return node containing the largest item.
     */
    private AvlNode findMax(AvlNode t) {
        if (t == null) {
            return t;
        }

        while (t.right != null) {
            t = t.right;
        }
        return t;
    }

    /**
     * Internal method to find an item in a subtree.
     *
     * @param x is item to search for.
     * @param t the node that roots the tree.
     * @return true if x is found in subtree.
     */
    private boolean contains(String x, AvlNode t) {
        while (t != null) {
            int compareResult = x.compareTo(t.element);

            if (compareResult < 0) {
                t = t.left;
            } else if (compareResult > 0) {
                t = t.right;
            } else {
                return true;    // Match
            }
        }

        return false;   // No match
    }

    /**
     * Internal method to print a subtree in sorted order.
     *
     * @param t the node that roots the tree.
     */
    private void printTree(AvlNode t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }

    /**
     * Return the height of node t, or -1, if null.
     */
    private int height(AvlNode t) {
        return t == null ? -1 : t.height;
    }

    /**
     * Rotate binary tree node with left child. For AVL trees, this is a single
     * rotation for case 1. Update heights, then return new root.
     */
    private AvlNode rotateWithLeftChild(AvlNode k2) {
        AvlNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    /**
     * Rotate binary tree node with right child. For AVL trees, this is a single
     * rotation for case 4. Update heights, then return new root.
     */
    private AvlNode rotateWithRightChild(AvlNode k1) {
        AvlNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.right), k1.height) + 1;
        return k2;
    }

    /**
     * Double rotate binary tree node: first left child with its right child;
     * then node k3 with new left child. For AVL trees, this is a double
     * rotation for case 2. Update heights, then return new root.
     */
    private AvlNode doubleWithLeftChild(AvlNode k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    /**
     * Double rotate binary tree node: first right child with its left child;
     * then node k1 with new right child. For AVL trees, this is a double
     * rotation for case 3. Update heights, then return new root.
     */
    private AvlNode doubleWithRightChild(AvlNode k1) {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }

    private static class AvlNode {

        AvlNode(String theElement) {
            this(theElement, null, null);
        }

        AvlNode(String theElement, AvlNode lt, AvlNode rt) {
            element = theElement;
            left = lt;
            right = rt;
            height = 0;
            lineNumbers = new LinkedList<>();//added a linked list
        }

        String element;      // The data in the node
        LinkedList<Integer> lineNumbers;//added a linked list instance variable
        AvlNode left;         // Left child
        AvlNode right;        // Right child
        int height;       // Height

    }

    /**
     * The tree root.
     */
    private AvlNode root;
}
