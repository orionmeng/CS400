import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Stack;

/**
 * Red-Black Tree implementation with a Node inner class for representing
 * the nodes of the tree. Currently, this implements a Binary Search Tree that
 * we will turn into a red black tree by modifying the insert functionality.
 * In this activity, we will start with implementing rotations for the binary
 * search tree insert algorithm. You can use this class' insert method to build
 * a regular binary search tree, and its toString method to display a level-order
 * traversal of the tree.
 */
public class RedBlackTree<T extends Comparable<T>> implements SortedCollectionInterface<T> {

    /**
     * This class represents a node holding a single value within a binary tree
     * the parent, left, and right child references are always maintained.
     */
    protected static class Node<T> {
        public T data;
        public Node<T> parent; // null for root node
        public Node<T> leftChild; 
        public Node<T> rightChild; 
        public Node(T data) { this.data = data; }
        public boolean isBlack;
        
        /**
         * @return true when this node has a parent and is the left child of
         * that parent, otherwise return false
         */
        public boolean isLeftChild() {
            return parent != null && parent.leftChild == this;
        }
        /**
         * This method performs a level order traversal of the tree rooted
         * at the current node. The string representations of each data value
         * within this tree are assembled into a comma separated string within
         * brackets (similar to many implementations of java.util.Collection).
         * Note that the Node's implementation of toString generates a level
         * order traversal. The toString of the RedBlackTree class below
         * produces an in-order traversal of the nodes / values of the tree.
         * This method will be helpful as a helper for the debugging and testing
         * of your rotation implementation.
         * @return string containing the values of this tree in level order
         */
        @Override
        public String toString() {
            String output = "Movies:\n";
            LinkedList<Node<T>> q = new LinkedList<>();
            q.add(this);
            while(!q.isEmpty()) {
                Node<T> next = q.removeFirst();
                if(next.leftChild != null) q.add(next.leftChild);
                if(next.rightChild != null) q.add(next.rightChild);
                output += next.data.toString();
                if(!q.isEmpty()) output += "\n";
            }
            return output;
        }
    }

    protected Node<T> root; // reference to root node of tree, null when empty
    protected int size = 0; // the number of values in the tree

    /**
     * Performs a naive insertion into a binary search tree: adding the input
     * data value to a new node in a leaf position within the tree. After  
     * this insertion, no attempt is made to restructure or balance the tree.
     * This tree will not hold null references, nor duplicate data values.
     * @param data to be added into this binary search tree
     * @return true if the value was inserted, false if not
     * @throws NullPointerException when the provided data argument is null
     * @throws IllegalArgumentException when the newNode and subtree contain
     *      equal data references
     */
    @Override
    public boolean insert(T data) throws NullPointerException, IllegalArgumentException {
        // null references cannot be stored within this tree
        if(data == null) throw new NullPointerException(
            "This RedBlackTree cannot store null references.");

        Node<T> newNode = new Node<>(data);
        newNode.isBlack = false;
        if(root == null) { root = newNode; root.isBlack = true; size++; return true; } // add first node to an empty tree
        else{
            root.isBlack = true;
            boolean returnValue = insertHelper(newNode,root); // recursively insert into subtree
            if (returnValue) size++;
        else throw new IllegalArgumentException(
            "This RedBlackTree already contains that value.");
            return returnValue;
        }
    }

    /** 
     * Recursive helper method to find the subtree with a null reference in the
     * position that the newNode should be inserted, and then extend this tree
     * by the newNode in that position.
     * @param newNode is the new node that is being added to this tree
     * @param subtree is the reference to a node within this tree which the 
     *      newNode should be inserted as a descendant beneath
     * @return true is the value was inserted in subtree, false if not
     */
    private boolean insertHelper(Node<T> newNode, Node<T> subtree) {
        int compare = newNode.data.compareTo(subtree.data);

        // store newNode within left subtree of subtree
        if(compare < 0) {
            if(subtree.leftChild == null) { // left subtree empty, add here
                subtree.leftChild = newNode;
                newNode.parent = subtree;
                enforceRBTreePropertiesAfterInsert(this, newNode);
                return true;
            // otherwise continue recursive search for location to insert
            } else return insertHelper(newNode, subtree.leftChild);
        }

        // store newNode within the right subtree of subtree
        else { 
            if(subtree.rightChild == null) { // right subtree empty, add here
                subtree.rightChild = newNode;
                newNode.parent = subtree;
                enforceRBTreePropertiesAfterInsert(this, newNode);
                return true;
            // otherwise continue recursive search for location to insert
            } else return insertHelper(newNode, subtree.rightChild);
        }
    }

    /*
     * This method enforces the RedBlackTree properties after inserting a node.
     */
    private void enforceRBTreePropertiesAfterInsert(RedBlackTree tree, Node<T> node) {
      while (!node.parent.isBlack) {
        if (node.parent == node.parent.parent.rightChild) {
          Node<T> relative = node.parent.parent.leftChild;
          if (relative == null) {
            if (node == node.parent.leftChild) {
              node = node.parent;
              rotate(node.leftChild,node);
            }
            node.parent.isBlack = true;
            node.parent.parent.isBlack = false;
            rotate(node.parent.parent.rightChild,node.parent.parent);
          } else if (relative.isBlack) {
            if (node == node.parent.leftChild) {
              node = node.parent;
              rotate(node.leftChild,node);
            }
            node.parent.isBlack = true;
            node.parent.parent.isBlack = false;
            rotate(node.parent.parent.rightChild,node.parent.parent);
          } else {
            relative.isBlack = true;
            node.parent.isBlack = true;
            node.parent.parent.isBlack = false;
            node = node.parent.parent;
          }
        } else {
          Node<T> relative = node.parent.parent.rightChild;
          if (relative == null) {
            if (node == node.parent.rightChild) {
              node = node.parent;
              rotate(node.rightChild,node);
            }
            node.parent.isBlack = true;
            node.parent.parent.isBlack = false;
            rotate(node.parent.parent.leftChild,node.parent.parent);
          } else if (relative.isBlack) {
            if (node == node.parent.rightChild) {
              node = node.parent;
              rotate(node.rightChild,node);
            }
            node.parent.isBlack = true;
            node.parent.parent.isBlack = false;
            rotate(node.parent.parent.leftChild,node.parent.parent);
          } else {
            relative.isBlack = true;
            node.parent.isBlack = true;
            node.parent.parent.isBlack = false;
            node = node.parent.parent;
          }
        }
        if (tree.root == node) {
          break;
        }
      }
      tree.root.isBlack = true;
    }

    /**
     * Performs the rotation operation on the provided nodes within this tree.
     * When the provided child is a leftChild of the provided parent, this
     * method will perform a right rotation. When the provided child is a
     * rightChild of the provided parent, this method will perform a left rotation.
     * When the provided nodes are not related in one of these ways, this method
     * will throw an IllegalArgumentException.
     * @param child is the node being rotated from child to parent position
     *      (between these two node arguments)
     * @param parent is the node being rotated from parent to child position
     *      (between these two node arguments)
     * @throws IllegalArgumentException when the provided child and parent
     *      node references are not initially (pre-rotation) related that way
     */
    private void rotate(Node<T> child, Node<T> parent) throws IllegalArgumentException {
      if (parent.rightChild == child) {
        //      Parent
        //          \
        //          Child
        if (parent.parent == null) { // if parent is the root
          this.root = parent; // ensure root
          boolean prc = true;
          if (parent.rightChild != null) {
            prc = false;
          }
          if (child.leftChild != null) { // link baby with parent
            //      Parent
            //          \
            //          Child
            //          /
            //      Baby
            Node<T> baby = child.leftChild;
            parent.rightChild = baby; // connect baby as child to parent
            baby.parent = parent; // connect parent as parent to baby
          } else {
            parent.rightChild = null;
          }
          child.parent = null; // set child parent to null
          child.leftChild = parent; // connect parent as child to child
          parent.parent = child; // connect child as parent to parent
          if (prc) {
            parent.rightChild = null; // ensure null
          }
          this.root = child; // ensure new root
          //        Child
          //        /
          //    Parent
          //        \
          //        Baby
          //            \
          //            null?
        } else { // if parent is not the root
          //    Grandparent
          //        |
          //      Parent
          //          \
          //          Child
          Node<T> grandparent = parent.parent;
          if (child.leftChild != null) {
            //    Grandparent
            //        |
            //      Parent
            //          \
            //          Child
            //          /
            //      Baby
            Node<T> baby = child.leftChild;
            parent.rightChild = baby; // connect baby as child to parent
            baby.parent = parent; // connect parent as parent to baby
          } else {
            parent.rightChild = null;
          }
          if (parent.isLeftChild()) {
            grandparent.leftChild = child; // connect child as leftChild of grandparent
          } else {
            grandparent.rightChild = child; // connect child as rightChild of grandparent
          }
          child.parent = grandparent; // connect grandparent as parent to child
          child.leftChild = parent; // connect parent as child to child
          parent.parent = child; // connect child as parent to parent
          //    Grandparent
          //        |
          //      Child
          //        /
          //    Parent
          //        \
          //        Baby
        }
      } else if (parent.leftChild == child) {
        //      Parent
        //      /
        //  Child
        if (parent.parent == null) { // if parent is the root
          this.root = parent; // ensure root
          if (child.rightChild != null) {
            //      Parent
            //      /
            //  Child
            //      \
            //      Baby
            Node<T> baby = child.rightChild;
            parent.leftChild = baby; // connect baby as child to parent
            baby.parent = parent; // connect parent as parent to baby
          } else {
            parent.leftChild = null;
          }
          child.parent = null; // set child parent to null
          child.rightChild = parent; // connect parent as child to child
          parent.parent = child; // connect child as parent to parent
          this.root = child;
          //        Child
          //            \
          //            Parent
          //            /
          //        Baby
          //        /
          //    null?
        } else { // if parent is not the root
          //    Grandparent
          //        |
          //      Parent
          //        /
          //    Child
          Node<T> grandparent = parent.parent;
          if (child.rightChild != null) {
            Node<T> baby = child.rightChild;
            parent.leftChild = baby; // connect baby as child to parent
            baby.parent = parent; // connect parent as parent to baby
          } else {
            parent.leftChild = null;
          }
          if (parent.isLeftChild()) {
            grandparent.leftChild = child; // connect child as leftChild to grandparent
          } else {
            grandparent.rightChild = child; // connect child as rightChild to grandparent
          }
          child.parent = grandparent; // connect grandparent as parent to child
          child.rightChild = parent; // connect parent as child to child
          parent.parent = child; // connect child as parent to parent
          //    Grandparent
          //        |
          //      Child
          //        \
          //        Parent
          //        /
          //    Baby
        }
      } else {
        throw new IllegalArgumentException();
      }
    }

    /**
     * Get the size of the tree (its number of nodes).
     * @return the number of nodes in the tree
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Method to check if the tree is empty (does not contain any node).
     * @return true of this.size() return 0, false if this.size() > 0
     */
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Checks whether the tree contains the value *data*.
     * @param data the data value to test for
     * @return true if *data* is in the tree, false if it is not in the tree
     */
    @Override
    public boolean contains(T data) {
        // null references will not be stored within this tree
        if(data == null) throw new NullPointerException(
            "This RedBlackTree cannot store null references.");
        return this.containsHelper(data, root);
    }

    /**
     * Recursive helper method that recurses through the tree and looks
     * for the value *data*.
     * @param data the data value to look for
     * @param subtree the subtree to search through
     * @return true of the value is in the subtree, false if not
     */
    private boolean containsHelper(T data, Node<T> subtree) {
        if (subtree == null) {
            // we are at a null child, value is not in tree
            return false;
        } else {
            int compare = data.compareTo(subtree.data);
            if (compare < 0) {
                // go left in the tree
                return containsHelper(data, subtree.leftChild);
            } else if (compare > 0) {
                // go right in the tree
                return containsHelper(data, subtree.rightChild);
            } else {
                // we found it :)
                return true;
            }
        }
    }

    /**
     * Returns an iterator over the values in in-order (sorted) order.
     * @return iterator object that traverses the tree in in-order sequence
     */
    @Override
    public Iterator<T> iterator() {
        // use an anonymous class here that implements the Iterator interface
        // we create a new on-off object of this class every time the iterator
        // method is called
        return new Iterator<T>() {
            // a stack and current reference store the progress of the traversal
            // so that we can return one value at a time with the Iterator
            Stack<Node<T>> stack = null;
            Node<T> current = root;

            /**
             * The next method is called for each value in the traversal sequence.
             * It returns one value at a time.
             * @return next value in the sequence of the traversal
             * @throws NoSuchElementException if there is no more elements in the sequence
             */
            public T next() {
                // if stack == null, we need to initialize the stack and current element
                if (stack == null) {
                    stack = new Stack<Node<T>>();
                    current = root;
                }
                // go left as far as possible in the sub tree we are in until we hit a null
                // leaf (current is null), pushing all the nodes we fund on our way onto the
                // stack to process later
                while (current != null) {
                    stack.push(current);
                    current = current.leftChild;
                }
                // as long as the stack is not empty, we haven't finished the traversal yet;
                // take the next element from the stack and return it, then start to step down
                // its right subtree (set its right sub tree to current)
                if (!stack.isEmpty()) {
                    Node<T> processedNode = stack.pop();
                    current = processedNode.rightChild;
                    return processedNode.data;
                } else {
                    // if the stack is empty, we are done with our traversal
                    throw new NoSuchElementException("There are no more elements in the tree");
                }

            }

            /**
             * Returns a boolean that indicates if the iterator has more elements (true),
             * or if the traversal has finished (false)
             * @return boolean indicating whether there are more elements / steps for the traversal
             */
            public boolean hasNext() {
                // return true if we either still have a current reference, or the stack
                // is not empty yet
                return !(current == null && (stack == null || stack.isEmpty()) );
            }
            
        };
    }

    /**
     * This method performs an in-order traversal of the tree. The string 
     * representations of each data value within this tree are assembled into a
     * comma separated string within brackets (similar to many implementations 
     * of java.util.Collection, like java.util.ArrayList, LinkedList, etc).
     * Note that this RedBlackTree class implementation of toString generates an
     * in-order traversal. The toString of the Node class class above
     * produces a level order traversal of the nodes / values of the tree.
     * @return string containing the ordered values of this tree (in-order traversal)
     */
    @Override
    public String toString() {
        // use the in-order Iterator that we get by calling the iterator method above
        // to generate a string of all values of the tree in (ordered) in-order
        // traversal sequence
        Iterator<T> treeNodeIterator = this.iterator();
        StringBuffer sb = new StringBuffer();
        sb.append("Movies:\n");
        if (treeNodeIterator.hasNext())
            sb.append(treeNodeIterator.next());
        while (treeNodeIterator.hasNext()) {
            T data = treeNodeIterator.next();
            sb.append("\n");
            sb.append(data.toString());
        }
        sb.append("\n");
        return sb.toString();
    }

}
