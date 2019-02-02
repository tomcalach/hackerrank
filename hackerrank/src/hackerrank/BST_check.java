package hackerrank;

import java.util.HashMap;
import hackerrank.Node;
public class BST_check {
	
	boolean checkBST(Node root) {
        if(root.left != null && root.right != null && root.left.data == root.right.data){return false;}
        if(root.left == null && root.right == null){return true;}
        int maxNum = root.data;
        HashMap<Integer, Node> parents = new HashMap<Integer, Node>();
        HashMap<Integer, Integer> biggerThan = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> smallerThan = new HashMap<Integer, Integer>();
        parents.put(root.data, null); 
        Node currentNode = root;
        while (true) {
//            first try to go to the left
            if (currentNode.left != null && (!parents.containsKey(currentNode.left.data) || parents.get(currentNode.left.data) != currentNode)) {
                if(currentNode.left.data >= currentNode.data) {return false;}
                if(biggerThan.containsKey(currentNode.data) && currentNode.left.data <= biggerThan.get(currentNode.data)) {return false;}
                parents.put(currentNode.left.data, currentNode);
                if(biggerThan.containsKey(currentNode.data)) {biggerThan.put(currentNode.left.data, biggerThan.get(currentNode.data));}
                smallerThan.put(currentNode.left.data, currentNode.data);
                currentNode = currentNode.left;
                
            } else if (currentNode.right != null && (!parents.containsKey(currentNode.right.data) || parents.get(currentNode.right.data) != currentNode)) {
                if(currentNode.right.data <= currentNode.data) {return false;}
                if(smallerThan.containsKey(currentNode.data) && currentNode.right.data >= smallerThan.get(currentNode.data)) {return false;}
                parents.put(currentNode.right.data, currentNode);
                if(smallerThan.containsKey(currentNode.data)) {smallerThan.put(currentNode.right.data, smallerThan.get(currentNode.data));}
                biggerThan.put(currentNode.right.data, currentNode.data);
                currentNode = currentNode.right;
                if(currentNode.data > maxNum) {maxNum = currentNode.data;}
                
            } else {
                currentNode = parents.get(currentNode.data);
                
            }
            if (currentNode.data >= maxNum &&
            (currentNode.left == null || (parents.containsKey(currentNode.left.data) && parents.get(currentNode.left.data) == currentNode))  &&
            (currentNode.right == null || (parents.containsKey(currentNode.right.data) && parents.get(currentNode.right.data) == currentNode)))
            {
                return true;
            }

        }

	}
	
	boolean rightWayToCheckBST(Node root) {
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
}
