package hackerrank;

import java.util.HashMap;

public class AVL_check {
	
	boolean isBalanced(Node node)  
    { 
        int lh; /* for height of left subtree */
   
        int rh; /* for height of right subtree */
   
        /* If tree is empty then return true */
        if (node == null) 
            return true; 
   
        /* Get the height of left and right sub trees */
        lh = height(node.left); 
        rh = height(node.right); 
   
        if (Math.abs(lh - rh) <= 1
                && isBalanced(node.left) 
                && isBalanced(node.right))  
            return true; 
   
        /* If we reach here then tree is not height-balanced */
        return false; 
    } 
   
    /* UTILITY FUNCTIONS TO TEST isBalanced() FUNCTION */
    /*  The function Compute the "height" of a tree. Height is the 
        number of nodes along the longest path from the root node 
        down to the farthest leaf node.*/
    static int height(Node node)  
    { 
        /* base case tree is empty */
        if (node == null) 
            return 0; 
   
        /* If tree is not empty then height = 1 + max of left 
         height and right heights */
        return 1 + Math.max(height(node.left), height(node.right)); 
    } 
	boolean checkBST(Node root) {
	    return checkBST(root, 0, 10000);
	}

	boolean checkBST(Node root, int minValue, int maxValue) {
	    if (root == null) {
	        return true;
	    }
	    
	    if (root.data < minValue || root.data > maxValue) {
	        return false;
	    }
	    
	    return (    checkBST(root.left, minValue, root.data - 1) 
	            &&  checkBST(root.right, root.data + 1, maxValue)
	            );
	}
	
	
	public static boolean checkAVL(Node root) {
		return checkAVL(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
	}
	
	static boolean checkAVL(Node root, double minBound, double maxBound) {
		if (root == null)
			return true;
		
		if ( maxBound <= root.data || root.data <= minBound) {
			return false;
		}
		int lHeight = height(root.left); 
        int rHeight = height(root.right);
        if (Math.abs(lHeight-rHeight) > 1) {
        	return false;
        }
        return( checkAVL(root.left, minBound, (double) root.data)
        	&& 	checkAVL(root.right, (double) root.data,  maxBound));
        
	}
	
	public static int findXthElement(Node root, int x) {
		Node node = root;
		HashMap<Node, Node> parents = new HashMap<Node, Node>();
		int currentLowest = -1;
		while(x > 0) {
			if ((node.left == null) || currentLowest >= node.left.data) {
				if(node.data > currentLowest) {x--; currentLowest = node.data;}
				if (node.right != null && currentLowest < node.right.data) {
					parents.put(node.right, node);
					node = node.right;
				}else {
					node = parents.get(node);
				}
			}else {
				parents.put(node.left, node);
				node = node.left;
			}
		}
		return currentLowest;
	}
	public static int findTheElementX(Node root, int x) {
		Node node = root;
		HashMap<Node, Node> parents = new HashMap<Node, Node>();
		int currentLowest = -1;
		int xInd = 0;
		while(true) {
			if ((node.left == null) || currentLowest >= node.left.data) {
				if(node.data > currentLowest) {
					xInd++; 
					currentLowest = node.data;
					if(node.data == x) {return xInd;}
				}
				if (node.right != null && currentLowest < node.right.data) {
					parents.put(node.right, node);
					node = node.right;
				}else {
					node = parents.get(node);
				}
			}else {
				parents.put(node.left, node);
				node = node.left;
			}
		}
	}

}
