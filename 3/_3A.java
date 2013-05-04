import java.awt.Point;
import java.io.BufferedInputStream;
import java.util.Scanner;

public class _3A {

	static Point start = new Point();
	static Point goal = new Point();

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		char[] ch;

		ch = in.nextLine().toCharArray();
		start.x = (int) ch[0];
		start.y = Integer.parseInt("" + ch[1]);

		ch = in.nextLine().toCharArray();
		goal.x = (int) ch[0];
		goal.y = Integer.parseInt("" + ch[1]);

		String output = "";
		int count;
		for (count = 0; !(start.x == goal.x && start.y == goal.y); count++) {
			// c‰¡
			if (start.x == goal.x) {
				if (start.y > goal.y) {
					output += "D\n";
					start.y--;
				} else {
					output += "U\n";
					start.y++;
				}
			} else if (start.y == goal.y) {
				if (start.x > goal.x) {
					output += "L\n";
					start.x--;
				} else {
					output += "R\n";
					start.x++;
				}
			} 
			// Î‚ß
			else if (start.x > goal.x) {
				if (start.y > goal.y) {
					output += "LD\n";
					start.x--;
					start.y--;
				} else {
					output += "LU\n";
					start.x--;
					start.y++;
				}
			} else {
				if (start.y > goal.y) {
					output += "RD\n";
					start.x++;
					start.y--;
				} else {
					output += "RU\n";
					start.x++;
					start.y++;
				}
			}
		}
		System.out.printf("%d\n%s", count, output);
		in.close();
		return;
	}
}
