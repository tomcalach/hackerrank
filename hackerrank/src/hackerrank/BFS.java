package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BFS {
	
	public int BFSshortestPath(Node start, Node end) {
		
		List<Node> queue = new ArrayList<Node>();
		queue.add(start);
		HashMap<Node,Integer> path = new HashMap<Node,Integer>();
		path.put(start, 0);
		
		while(queue.size() > 0) {
			Node node = queue.get(0);
			queue.remove(0);
			if (node == end) {return path.get(node);}
			
			for(int i = 0; i < node.edges.length; i++) {
				queue.add(node.edges[i]);
				path.put(node.edges[i], path.get(node) + 1);
			}
		return -1;
		}
		
		
		
		
	}

}
