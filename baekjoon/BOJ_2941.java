package baekjoon;

import java.util.Scanner;

/*
 * 2941. 크로아티아 알파벳
 * 입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
 */
public class BOJ_2941 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] list = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		for(int i=0; i<list.length; i++) {
			if(input.contains(list[i])) {
				input = input.replace(list[i], "A");
			}
		}
		System.out.println(input.length());
	}

}
