package andrew;
import java.util.*;

public class SegmentTreeTest {
	public static int [] A = {2,3,4,1,0};
	public static int [] segTree;
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		//build a segTree to find the range minimum
		//1. calculate the size of segTree
		//2. create segTree array
		//3. create a function called buildSegTreeMin
		//to store the data into segTree
		
		int height = (int)Math.ceil(Math.log(A.length)/Math.log(2)+1);
		int size = (int)Math.pow(2,height)-1;
		
		segTree = new int [size];
		
		buildSegTreeMin(0,A.length-1,0);
		
	}

		public static int buildSegTreeMin(int l,int R, int index) {
			
			if(l==R) {
				segTree[index] = A[l];
			}
			int mid=(l+R)/2;
			segTree[index] = 
					Math.min(buildSegTreeMin(l,mid,2*index+1),
					buildSegTreeMin(mid+1, R, 2*index+2));
			return segTree[index];
		}
		
		//l is left index
		//r i right index
		//i is original array index
		//value is the updated value
		public static void update(int l, int R, int i, int value, int index) {
			if(i>R || i<l) {
				return;
			}
			if(segTree[index]>value) {
				segTree[index] = value;
				
			}
			//for sum....
			//int diff = value - A[i];
			//segTree[index] += diff;
			int mid = (l+R)/2;
			update(l, mid, i, value, index*2+1);
			update(mid+1, R, i, value, index*2+2);
		}
}
