package pathfinder;

import java.util.ArrayList;

public class main {

	public static void main(String[] args) {

		// REAL CIRCUIT

		checkPoint A = new checkPoint(1,new int[] {0},new int[] {14,13,2},1,3);//Depart
		checkPoint B = new checkPoint(2,new int[] {14,13},new int[] {3,1},2,2);
		checkPoint C = new checkPoint(3,new int[] {4,5},new int[] {2},2,1);
		checkPoint D = new checkPoint(4,new int[] {0},new int[] {5,3},1,2);//Arrive
		checkPoint E = new checkPoint(5,new int[] {4,3},new int[] {6,7,8},2,3);
		checkPoint F = new checkPoint(6,new int[] {7,10,12,13},new int[] {5,7,8},4,3);
		checkPoint G = new checkPoint(7,new int[] {8,6,5},new int[] {10,12,13,6},3,4);
		checkPoint H = new checkPoint(8,new int[] {9},new int[] {7,6,5},1,3);
		checkPoint I = new checkPoint(9,new int[] {10,11},new int[] {8},2,1);
		checkPoint J = new checkPoint(10,new int[] {9,11},new int[] {7,12,6,13},2,4);
		checkPoint K = new checkPoint(11,new int[] {16,17,18},new int[] {10,9},3,2);
		checkPoint L = new checkPoint(12,new int[] {14,15,16},new int[] {10,7,6,13},3,4);
		checkPoint M = new checkPoint(13,new int[] {6,7,10,12},new int[] {14,2,1},4,3);
		checkPoint N = new checkPoint(14,new int[] {12,16,15},new int[] {13,2,1},3,3);
		checkPoint O = new checkPoint(15,new int[] {19,20},new int[] {16,12,14},2,3);
		checkPoint P = new checkPoint(16,new int[] {17,11,18},new int[] {12,14,15},3,3);
		checkPoint Q = new checkPoint(17,new int[] {11,18,16},new int[] {19,18,20},3,3);
		checkPoint R = new checkPoint(18,new int[] {11,16,17},new int[] {17,19,20},3,3);
		checkPoint S = new checkPoint(19,new int[] {15,20},new int[] {17,18,20},2,3);
		checkPoint T = new checkPoint(20,new int[] {18,17,19},new int[] {19,15},3,2);
		
		ArrayList<checkPoint> CPlist = new ArrayList<checkPoint>();
		CPlist.add(A);
		CPlist.add(B);
		CPlist.add(C);
		CPlist.add(D);
		CPlist.add(E);
		CPlist.add(F);
		CPlist.add(G);
		CPlist.add(H);
		CPlist.add(I);
		CPlist.add(J);
		CPlist.add(K);
		CPlist.add(L);
		CPlist.add(M);
		CPlist.add(N);
		CPlist.add(O);
		CPlist.add(P);
		CPlist.add(Q);
		CPlist.add(R);
		CPlist.add(S);
		CPlist.add(T);

		// END OF REAL CIRCUIT



		// TEST CIRCUIT

		/*checkPoint A = new checkPoint(1,new int[] {0},new int[] {2},1,1);//Depart
		checkPoint B = new checkPoint(2,new int[] {1},new int[] {5,3},1,2);
		checkPoint C = new checkPoint(3,new int[] {4},new int[] {2,5},1,2);
		checkPoint D = new checkPoint(4,new int[] {3},new int[] {6,5},1,2);//Arrive
		checkPoint E = new checkPoint(5,new int[] {2,3},new int[] {6,4},2,2);
		checkPoint F = new checkPoint(6,new int[] {4,5},new int[] {7},2,1);
		checkPoint G = new checkPoint(7,new int[] {6},new int[] {0},2,1);
		ArrayList<checkPoint> CPlist = new ArrayList<checkPoint>();
		CPlist.add(A);
		CPlist.add(B);
		CPlist.add(C);
		CPlist.add(D);
		CPlist.add(E);
		CPlist.add(F);
		CPlist.add(G);*/
		// END OF TEST CIRCUIT


		Race go = new Race(26,1,CPlist,20,4);
		go.Run();
		go.printPathFound();

	}

}
