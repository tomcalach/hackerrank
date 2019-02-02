package hackerrank;

public class BST_Lowest_Common_Ancestor {
	
	public static Node lca(Node root, int v1, int v2) {
      	int lowNode = Math.min(v1, v2);
        int highNode = Math.max(v1, v2);
        Node currentNode = root;
        while(true){
            if (currentNode.data >= lowNode){
                if (currentNode.data <= highNode){return currentNode;}
                else{
                    currentNode = currentNode.left;
                }
            } else{
                currentNode = currentNode.right;
            }
        }
    }
}
