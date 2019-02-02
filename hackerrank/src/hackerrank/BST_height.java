package hackerrank;

import java.util.*;

class Node {
	    Node left;
	    Node right;
	    int data;
	    
	    Node(int data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

class Solution {

		/*
	    class Node 
	    	int data;
	    	Node left;
	    	Node right;
		*/
	public static int height(Node root) {
        if(root.left == null && root.right == null){return 0;}
        int maxHeight = 0;
        int level = 0;
        int maxNum = root.data;
        HashMap<Integer, Node> parents = new HashMap<Integer, Node>();
        parents.put(root.data, null);
        Node currentNode = root;
        while (true) {
            if (currentNode.left != null && !parents.containsKey(currentNode.left.data)) {
                parents.put(currentNode.left.data, currentNode);
                currentNode = currentNode.left;
                level++;
            } else if (currentNode.right != null && !parents.containsKey(currentNode.right.data)) {
                parents.put(currentNode.right.data, currentNode);
                currentNode = currentNode.right;
                if(currentNode.data > maxNum) {maxNum = currentNode.data;}
                level++;
            } else {
                currentNode = parents.get(currentNode.data);
                level--;
            }
            if (level > maxHeight) {
                maxHeight = level;
            }
            if (currentNode.data >= maxNum &&
            (currentNode.left == null || parents.containsKey(currentNode.left.data))  &&
            (currentNode.right == null || parents.containsKey(currentNode.right.data)))
            {
                return maxHeight;
            }
            if (currentNode.data > maxNum) {
                maxNum = currentNode.data;
            }
        }

    }
}
