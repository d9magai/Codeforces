import java.io.BufferedInputStream;
import java.util.Scanner;

public class _4B {

	private static class Times {
		int max;
		int min;
		int d;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		int i, days, sumTime, sumMaxTime = 0, sumMinTime = 0;

		days = in.nextInt();
		sumTime = in.nextInt();

		Times[] time = new Times[days];
		for (i = 0; i < days; i++) {
			time[i] = new Times();
			time[i].min = in.nextInt();
			time[i].max = in.nextInt();
			time[i].d = time[i].max - time[i].min;
			sumMinTime += time[i].min;
			sumMaxTime += time[i].max;
		}

		if (sumMaxTime < sumTime || sumTime < sumMinTime) {
			System.out.println("NO");
			in.close();
			return;
		} else {
			System.out.println("YES");
		}

		String output = "";
		int dTime = sumTime - sumMinTime;
		for (i = 0; i < days; i++) {
			if (dTime == 0) {
				output += String.valueOf(time[i].min);
			} else if (time[i].d <= dTime) {
				output += String.valueOf(time[i].max);
				dTime -= time[i].d;
			} else {
				output += String.valueOf(time[i].min + dTime);
				dTime = 0;
			}
			output += " ";
		}
		System.out.print(output);
		in.close();
	}
}
