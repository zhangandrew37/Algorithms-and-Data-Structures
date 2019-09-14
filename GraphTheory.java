package andrew;

import java.util.*;

public class GraphTheory {
	public static class Edge implements Comparable<Edge> {
		int bv;
		int ev;
		int cost;

		public Edge(int bv, int ev, int cost) {
			this.bv = bv;
			this.ev = bv;
			this.cost = cost;
		}
		public static void main(String[] args) {
			Edge[] edge = new Edge[5];
			edge[0] = new Edge(0, 1, 3);
			edge[1] = new Edge(0, 2, 7);
			edge[2] = new Edge(0, 3, 2);
			edge[3] = new Edge(1, 2, 5);
			edge[4] = new Edge(3, 2, 1);
			Arrays.sort(edge);
			for(int i=0; i<edge.length; i++){
			System.out.println(edge[i].bv + "-" + edge[i].ev + " cost "+edge[i].cost+" dollars");
			}
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			if (this.cost > o.cost) {
				return 1;
			} else if (this.cost < o.cost) {
				return -1;
			} else {
				return 0;
			}

		}
	}
}
