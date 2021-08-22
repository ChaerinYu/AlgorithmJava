package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1074. Z
 * @author user
 * Divide and Conquer
 */
public class BOJ_1074 {
	
	static int N, r, c; // 배열 크기(2^n), 행, 열
	static int cnt = 0, res;
	static int pow;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		r = Integer.parseInt(input[1]);
		c = Integer.parseInt(input[2]);
		
		pow = (int) Math.pow(2, N);
		go(0, 0, pow);
		
		System.out.println(res);
	}
	
	static void go(int sr, int sc, int size) {
		if(sr == r && sc ==c) {
			res = cnt; // 여기서 별도 변수 선언안하고 return한다면, map에 모든 숫자 넣은 최종값인 (2^n-1, 2^n-1) 좌표 값이 나온다.
			return;
		}
		
		// 찾고자하는 좌표가 범위안에 존재한다면 4사분면 나눠서 찾기
		if(r>=sr && c>=sc && r<sr+size && c<sc+size) {
			go(sr, sc, size/2);					// 2사분면
			go(sr, sc+size/2, size/2);			// 1사분면
			go(sr+size/2, sc, size/2);			// 3사분면
			go(sr+size/2, sc+size/2, size/2);	// 4사분면
		}
		// 좌표가 범위안에 없으면 그 범위는 건너뛴다. (divided map 크기만큼 cnt에 더해준다.)
		else {
			cnt += size*size;
		}
	}
}
