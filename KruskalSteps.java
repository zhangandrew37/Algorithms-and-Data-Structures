package andrew;
import java.util.*;

//https://dmoj.ca/problem/ds2

//1. Store all edges in an array and sort edges

//2. Keep track of nodes with disjoint set
//Disjoint Set - special data structure that allows you to keep track of which nodes are connected
	//(find) - given a node, find the set it belongs to
	//(union) - take two nodes and merge them

public class KruskalSteps {
	static int disjoint [] = new int[100005];
	
	//returns the head of a given node
	//we know that a node is a head node if the index is equal to its value
	public static int find(int x) {
		if(disjoint[x] == x) 
			return x;
		return find(disjoint[x]);
		
	}
	
	//takes two nodes and merges them
	public static void union(int x, int y) {
		int head_x = find(x);
		int head_y = find(y);
		disjoint[head_x] = head_y;
		
	}
	
	//initialize disjoint set of size n
	public static void init(int n) {
		for(int i=0; i<=n;i++) {
			disjoint[i] = i;
		}
	}
		public static void main(String [] args) {
			Scanner sc = new Scanner(System.in);
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int ans [] = new int [1000005]; //stores the answer
			int connections = 0; //if connections is not n-1 at the end, the graph is disconnected
			
			//initialize
			for(int i=1; i<=N; i++) {
				disjoint[i] = i;
			}
			//loop through all edges
			for(int i=0; i<M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				if(find(x) == find(y)) {
					ans[connections] = i;
					connections++;
					//merge
					union(x,y);
				}
			}
			if(connections != N-1) {
				System.out.print("Disconnected Graph" + connections);
			} else if(connections == N-1){
				for(int i=0; i<N; i++) {
					System.out.println(ans[i]);
				}
			}
		}

}
