import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;


public class Graph_BFS_DFS {
	private static HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();
	
	public static class Node {
		private int id;
		LinkedList<Node> adjacent = new LinkedList<Node>();
		
		private Node(int id){
			this.id = id;
		}
	}
	
	private static Node getNode(int id){
		if(nodeLookup.get(id) == null) {
			nodeLookup.put(id, new Node(id));
		}
		return nodeLookup.get(id);
	}
	
	public static void addEdge (int source, int destination) {
		Node s = getNode(source);
		Node d = getNode(destination);
		s.adjacent.add(d);
	}
	
	public static boolean hasPathDFS(int source, int destination){
		Node s = getNode(source);
		Node d = getNode(destination);
		
		HashSet<Integer> visited = new HashSet<Integer>();
		return hasPathDFS(s, d, visited);
	}
	
	private static boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited) {
		if (visited.contains(source.id)) {
			return false;
		}
		visited.add(source.id);
		if (source == destination) {
			return true;
		}
		for (Node child : source.adjacent) {
			if (hasPathDFS(child, destination, visited)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean hasPathBFS(int source, int destination) {
		return hasPathBFS(getNode(source), getNode(destination));
	}
	
	private static boolean hasPathBFS(Node source, Node destination) {
		LinkedList<Node> nextToVisit = new LinkedList<Node>();
		HashSet<Integer> visited = new HashSet<Integer>();
		nextToVisit.add(source);
		while(!nextToVisit.isEmpty()){
			Node node = nextToVisit.remove();
			if (node == destination) {
				return true;
			}
			
			if (visited.contains(node.id)) {
				continue;
			}
			visited.add(node.id);
			for (Node child : node.adjacent) {
				nextToVisit.add(child);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		addEdge(1, 2);
		addEdge(1, 3);
		addEdge(1, 4);
		addEdge(1, 6);
		addEdge(2, 3);
		addEdge(3, 6);
		addEdge(4, 6);
		addEdge(6, 5);
		addEdge(6, 8);
		addEdge(8, 7);
		System.out.println("DFS: ");
		System.out.println("Has path from 1 to 8: "+ hasPathDFS(1, 8));
		System.out.println("Has path from 2 to 7: "+ hasPathDFS(1, 7));
		System.out.println("Has path from 5 to 4: "+ hasPathDFS(5, 4));
		System.out.println("BFS: ");
		System.out.println("Has path from 1 to 8: "+ hasPathBFS(1, 8));
		System.out.println("Has path from 2 to 7: "+ hasPathDFS(1, 7));
		System.out.println("Has path from 5 to 4: "+ hasPathBFS(5, 4));
		
	}
}
