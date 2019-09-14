package andrew;
import java.util.*;

public class Kruskal1 {
	public static int [] parent;
	public static class Edge implements Comparable <Edge>{
		int bv;
		int ev;
		int cost;
		
		public Edge(int bv, int ev, int cost) {
			this.bv = bv;
			this.ev = ev;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			if(this.cost>o.cost)
			return 1;
		 else if(this.cost<o.cost) 
			return -1;
		 else 
			return 0;
		}
	}
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int V = 4;
		int E = 6;
		
		Edge [] edge = new Edge [E];
		
		for(int i=0; i<E; i++) {
			int bv = sc.nextInt();
			int ev = sc.nextInt();
			int cost = sc.nextInt();
			
			edge[i] = new Edge(bv, ev, cost);
		}
		Arrays.sort(edge);
		
		Edge [] mst = new Edge [V-1]; //v-1 will be the number of vertexes in least cost path
		parent = new int [V];
		Arrays.fill(parent,  -1);
		int index = 0;
		
		for(Edge e: edge) {
			int pb = find(e.bv);
			int pe = find(e.ev);
			if(pb!=pe) {
				mst [index] = e;
				union(pb, pe);
				index++;
				if(index==V-1) {
					break;
				}
			}
			System.out.println(e.bv+" " + e.ev+ " " + e.cost);
		}
}
	public static int find(int v) {
		//find the 
		if(parent [v]==-1) {//already arrays.fill with -1
			return v;
		}
		return find(parent[v]);
	}
	
	public static void union(int pb, int pe) {
		parent[pb] = pe;
	}
}
