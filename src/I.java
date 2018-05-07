import java.util.Scanner;

public class I {
	
	private int a;
	private int b;
	private int c;
	private int d;
	
	public I(int a, int b, int c, int d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	public int getWinner() {
		int team1 = a+c;
		int team2 = b+d;
		
		if (team1 > team2) {
			return 1;
		}
		else if (team2 > team1) {
			return 2;
		}
		else { // equal goals scored
			if (c > b) {
				return 1;
			}
			else if (c < b){
				return 2;
			}
			else {
				return -1;
			}
		}
	}
	
	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int numTests = sc.nextInt();
		for (int i = 0; i < numTests; i++) {
			I result = new I(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
			System.out.println(result.getWinner());
		}
		sc.close();
	}
}
