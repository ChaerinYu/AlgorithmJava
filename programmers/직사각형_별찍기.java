package programmers;

import java.util.Scanner;
/**
 * 2021.11.07
 * @author Chaerin Yu
 * 직사각형 별찍기
 * https://programmers.co.kr/learn/courses/30/lessons/12969
 */
public class 직사각형_별찍기 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b; i++) {
			for (int j = 0; j < a; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}

        System.out.println(sb.toString());
	}

}
