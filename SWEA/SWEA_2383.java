package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * 2383. [모의 SW 역량테스트] 점심 식사시간
 * @author user
 * https://herong.tistory.com/entry/SWEA-2383-%EC%A0%90%EC%8B%AC-%EC%8B%9D%EC%82%AC%EC%8B%9C%EA%B0%84-Simulation
 */
public class SWEA_2383 {

	static int N, rooms[][], pNum, sNum, usingStairs[]; // 방 크기, 방, 사람 수, 계단 수, 사람별 이용하는 계단
	static ArrayList<int[]> pLocs, sLocs; // 사람 위치, 계단 위치
	static int[][] personToStairs; // 사람-계단 거리
	
	static int res; // 답
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 방 크기
			
			rooms = new int[N][N]; // 방
			pLocs = new ArrayList<int[]>(); // 사람 위치
			sLocs = new ArrayList<int[]>(); // 계단 위치
			
			pNum = sNum = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					rooms[i][j] = Integer.parseInt(st.nextToken());
					// 사람 위치
					if(rooms[i][j] == 1) {
						pLocs.add(new int[] {i, j});
						pNum++;
					}
					// 계단 위치
					else if(rooms[i][j] > 1) {
						sLocs.add(new int[] {i, j});
						sNum++;
					}
				}
			}
			
			personToStairs = new int[pNum][sNum]; // 사람-계단 거리
			for (int i = 0; i < pNum; i++) {
				int[] pLoc = pLocs.get(i);
				for (int j = 0; j < sNum; j++) {
					int[] sLoc = sLocs.get(j);
					personToStairs[i][j] = Math.abs(pLoc[0]-sLoc[0])+Math.abs(pLoc[1]-sLoc[1]);
				}
			}
			
			res = 0;
			usingStairs = new int[pNum];
			dfs(0);
			
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	// 중복순열: 모든 경우의 수 최대 2^10
	private static void dfs(int depth) {
		// 모든 사람이 사용할 계단 정한 경우
		if(depth == pNum) {
			move();
			return;
		}
		// 계단 무조건 2개 존재
		for (int i = 0; i < 2; i++) {
			usingStairs[depth] = i;
			dfs(depth+1);
		}
	}

	private static void move() {
		PriorityQueue<Integer> stairs1 = new PriorityQueue<Integer>();
		PriorityQueue<Integer> stairs2 = new PriorityQueue<Integer>();
		
		// 계단 무조건 2개
		for (int i = 0; i < pNum; i++) {
			if(usingStairs[i] == 0) 
				stairs1.add(personToStairs[i][0]);
			else
				stairs2.add(personToStairs[i][1]);
		}
		
		int person = pNum; // 남은 사람
		int[] times1 = new int[3]; // 계단 이용하는 사람들의 남은 시간
		int[] times2 = new int[3];
		
		int time = 0;
		while(true) {
			// 종료조건: 모든 이용자가 계단 이용할 때 까지
			if(person == 0) {
				boolean flag = true;
				for (int i = 0; i < 3; i++) {
					if(times1[i] != 0) {
						flag = false;
						break;
					}
				}
				for (int i = 0; i < 3; i++) {
					if(times2[i] != 0) {
						flag = false;
						break;
					}
				}
				if(flag) break;
			}
//			break;
			
			// 계단은 최대 3명 이용 가능
			for (int i = 0; i < 3; i++) {
				// 현재 이용하는 사람 없는 경우
				if(times1[i] == 0) {
					// 계단 이용할 사람있는지 확인
					if(!stairs1.isEmpty()) {
						
						if(stairs1.peek() <= time) {
							
						}
					}
				}
			}
		}
		if(time < res) res = time;
	}

}
