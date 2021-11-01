package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_TEST {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double n1 = Double.parseDouble(st.nextToken());
		double n2 = Double.parseDouble(st.nextToken());
		double answer =  n1/n2;
		System.out.println(answer);
	}

}
