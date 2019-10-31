package day1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int i = 4;
		double d = 4.0;
		String s = "HackerRank ";
		int i_a;
		double d_a;
		String s_a;
		Scanner scan = new Scanner(System.in);
		i_a = scan.nextInt();
		d_a = scan.nextDouble();
		scan.useDelimiter("");
		s_a = scan.next().replaceAll("\n","");
		System.out.println(i + i_a);
		System.out.println(d + d_a);
		System.out.print(s.concat(s_a));
		scan.close();
	}
}
