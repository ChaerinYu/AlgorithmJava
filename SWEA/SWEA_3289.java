package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 3289. 서로소 집합
 * @author user
 * 초기에 {1}, {2}, ... {n} 이 각각 n개의 집합을 이루고 있다.
 * 여기에 합집합 연산과, 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산을 수행하려고 한다.
 * 
 * 첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
 * 각 테스트 케이스의 첫째 줄에 n(1≤n≤1,000,000), m(1≤m≤100,000)이 주어진다.
 * m은 입력으로 주어지는 연산의 개수이다.
 * 다음 m개의 줄에는 각각의 연산이 주어진다.
 * 합집합은 0 a b의 형태로 입력이 주어진다.
 * 이는 a가 포함되어 있는 집합과, b가 포함되어 있는 집합을 합친다는 의미이다.
 * 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산은 1 a b의 형태로 입력이 주어진다.
 * 이는 a와 b가 같은 집합에 포함되어 있는지를 확인하는 연산이다.
 * a와 b는 n 이하의 자연수이며 같을 수도 있다.
 * 
 * 각 테스트 케이스마다 1로 시작하는 입력에 대해서 같은 집합에 속해있다면 1을, 아니면 0을 순서대로 한줄에 연속하여 출력한다.
 */
public class SWEA_3289 {

	static int n, m; // 정점 수, 연산 수
	static int[] parents; // 부모님(대표) 정점 저장
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // test case
		
		for (int tc = 1; tc <= T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			StringBuilder sb = new StringBuilder();
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			make(); // 초기에 {1}, {2}, ... {n} 이 각각 n개의 집합 만들기
			
			sb.append("#").append(tc).append(" ");
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int cmd = Integer.parseInt(st.nextToken()); // 명령어 0: 합, 1: 확인
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				switch(cmd) {
					case 0:
						union(a,b);
						break;
					case 1:
						int aRoot = find(a);
						int bRoot = find(b);
						
						if(aRoot == bRoot) {
							sb.append(1);
						} else {
							sb.append(0);
						}
						break;
					default:
						System.out.println("wrong command");
						break;
				}
			}
			System.out.println(sb);
		}
			
	}
	
	// 집합 만들기 
	static void make() {
		parents = new int[n+1];
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
	}
	
	// 집합 합치기
	static void union(int a, int b) {
		int aRoot = find(a), bRoot = find(b);
		if(aRoot == bRoot) return; // 대표가 같으면 그대로 유지
		parents[bRoot] = aRoot; // b 대표를 a 대표로 변경
	}
	
	// 대표 찾기
	static int find(int a) {
		
		if(parents[a] == a) return a; // 대표가 나
		return parents[a] = find(parents[a]); // a의 부모를 a의 대표로 변경한다.
		
	}
}
