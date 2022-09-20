import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		int min = x;
		if (min > Math.abs(x - w))
			min = Math.abs(x - w);
		if (min > y)
			min = y;
		if (min > Math.abs(y - h))
			min = Math.abs(y - h);
		System.out.println(min);
	}
}