package Lesson4;
import java.util.*;

public class BFScode {
	public static void main(String [] args) {
		Scanner sc = new Scanner (System.in);
		int V = 8;
		boolean [][] map = new boolean [V][V];
		map [0][1] = true;
		map [1][0] = true;
		map [0][2] = true;
		map [2][0] = true;
		map [0][3] = true;
		map [3][0] = true;
		map [1][4] = true;
		map [4][1] = true;
		map [2][5] = true;
		map [5][2] = true;
		map [3][6] = true;
		map [6][3] = true;
		map [4][7] = true;
		map [7][4] = true;
		map [5][7] = true;
		map [7][5] = true;
		map [6][7] = true;
		map [7][6] = true;
		
		LinkedList<Integer> queue = new LinkedList<Integer> ();
		int step [] = new int [V];
		Arrays.fill(step, Integer.MAX_VALUE);
		queue.add(0);
		step [0] =0; 
		
		while(!queue.isEmpty()) {
			int curV = queue.pop();
			for(int col = 0; col<V; col++) {
				if(map[curV][col] == true && step[col] > step[curV] +1) {
					step [col] = step[curV] +1;
					queue.add(col);
				}
				
			}
			
		}
		System.out.println(step[7]);
	}

}
