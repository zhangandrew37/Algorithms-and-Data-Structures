package andrew;
import java.util.*;

public class SegmentTree {
	public static int[] A = {5,2,3,4,1};
	public static int[] segTree;
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		//Store the tree into segTree array
		//calculate the size of segTree
		//Math.cell round up, it means 5.4 is 6
		//log(8)/log(2) = 3
		//log(25)/log(5) = 2
		//log(81)/log(3) = 4
		int height = (int)Math.ceil(Math.log(A.length)/Math.log(2)+1);
		int size = (int)Math.pow(2,  height)-1;
		segTree = new int[size];
		buildSegTree(0,A.length-1,0);
		for(int number:segTree) {
			System.out.println(number);
		}
	}
	
	//L represents left index
	//R represent right index
	//index represents the index of segTree
	
	public static int buildSegTree(int l, int R, int index) {
		if(l==R) {
			segTree[index] = A[l];
			return segTree[index];
		}
		int mid = (l+R)/2; //(note that it will round down)
		return segTree [index] = buildSegTree(l, mid, 2*index+1) + //left side
				buildSegTree(mid+1, R, 2*index+2);
		
	}
}
