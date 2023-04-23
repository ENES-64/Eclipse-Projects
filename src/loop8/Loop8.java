package loop8;

public class Loop8 {
	public static void main(String[] args) {
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				if((i+j)>5)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			for(int j=1;j<=-1+i;j++)
				System.out.print("* ");
			System.out.println();
		}
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=4;j++) {
				if(i<j)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			for(int j=1;j<=4-i+1;j++)
				System.out.print("* ");
			System.out.println();
		}
	}
}