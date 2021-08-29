package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 14696. 딱지놀이
 * @author user
 * 규칙: 별 많은 사람 승
 * 별 같은 경우 동그라미 많은 사람 승
 * 별/동그라미 같은 경우, 네모 많은 사람 승
 * 별/동그라미/네모 같은 경우, 세모 많은 사람 승
 * 그 외 무승부
 * 별, 동그라미, 네모, 세모를 각각 숫자 4, 3, 2, 1로 표현한다.
 * 
 * 첫 번째 줄에는 딱지놀이의 총 라운드 수를 나타내는 자연수 N이 주어진다. N 은 1 이상 1,000 이하이다. 
 * 다음 줄에는 라운드 1에서 어린이 A가 내는 딱지에 나온 그림의 총 개수 a가 주어진다. a는 1 이상 100 이하이다.
 * 다음 줄에는 라운드 1에서 어린이 B가 내는 딱지에 나온 그림의 총 개수 b가 주어진다. b도 1 이상 100 이하이다.
 * 
 * 결과는 A가 승자라면 A, B가 승자라면 B, 무승부라면 D이다.
 */
public class BOJ_14696 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 라운드 수
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			int[] a = new int[5];
			int[] b = new int[5];
			
			st = new StringTokenizer(br.readLine(), " ");
			int aCardNum = Integer.parseInt(st.nextToken());
			for (int j = 0; j < aCardNum; j++) {
				int idx = Integer.parseInt(st.nextToken());
				a[idx]++;
			}
			st = new StringTokenizer(br.readLine(), " ");
			int bCardNum = Integer.parseInt(st.nextToken());
			for (int j = 0; j < bCardNum; j++) {
				int idx = Integer.parseInt(st.nextToken());
				b[idx]++;
			}
			
			// 그 외 무승부
			char res = 'D';
			if(a[4] != b[4]) {
				if(a[4]>b[4]) res = 'A';
				else if(a[4]<b[4]) res = 'B';
			}
			// 별 같은 경우 동그라미 많은 사람 승
			else if(a[3] != b[3]) {
				if(a[3]>b[3]) res = 'A';
				else if(a[3]<b[3]) res = 'B';
			}
			 // 별/동그라미 같은 경우, 네모 많은 사람 승
			else if(a[2] != b[2]) {
				if(a[2]>b[2]) res = 'A';
				else if(a[2]<b[2]) res = 'B';
			}
			 // 별/동그라미/네모 같은 경우, 세모 많은 사람 승
			else if(a[1] != b[1]) {
				if(a[1]>b[1]) res = 'A';
				else if(a[1]<b[1]) res = 'B';
			}
			
			System.out.println(res);
		}
	}
}
