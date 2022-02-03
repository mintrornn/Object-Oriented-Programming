import java.util.*;

public class ToH3 {
	public static Stack<Integer>[] tower = new Stack[4];
	
	public static void main(String[] args) {
		tower[1] = new Stack<Integer>();
		tower[2] = new Stack<Integer>();
		tower[3] = new Stack<Integer>();
		for(int i=3;i>0;i--) {
			tower[1].push(i); //ใส่
		}
		move(3,1, 2, 3);
		System.out.println("******* I GET " + (int)(Math.pow(2, 3)-1) + " STEPS *******");
	}
	public static void move(int n, int a, int b, int c) {
		if(n>0) {
			move(n-1, a, c, b);
			int x = tower[a].pop(); //ย้ายตำแหน่ง
			tower[c].push(x);
			System.out.println("Move " + n + " from " + "S" + a + " to rod " + "S" + c);
			move(n-1, b, a, c);
		}
	}
}
