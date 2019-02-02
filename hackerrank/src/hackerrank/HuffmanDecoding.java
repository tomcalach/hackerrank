package hackerrank;

public class HuffmanDecoding {
	
	void decode(String s, Node root) {
		/**
		 * @param s - a string of 1s and 0s, represent a string of letters, which can be decoded by the tree.
		 * @param root - the root of a Huffman coded tree of a specific unrevealed string.
		 * decode prints the string which is represented by s.
		 */
        Node currNode = root;
        for(char i: s.toCharArray()){
        	if( i == '0' ) {
        		if(currNode.left == null) {
        			System.out.print(currNode.data);
        			currNode = root.left;
        			
        		}else {
        			currNode = currNode.left;
        		}
        	
        	} else {
        		if(currNode.right == null) {
        			System.out.print(currNode.data);
        			currNode = root.right;
        			
        		}else {
        			currNode = currNode.right;
        		}
        	}

        }
        System.out.print(currNode.data); 
    }

}
