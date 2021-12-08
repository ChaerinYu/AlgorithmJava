package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_P2383_2 {
	static int N, map[][], ans;
	static ArrayList<int[]> gate, person;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("sample_input_2383.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		
		// 테스트 케이스별 수행
		for(int t=1;t<=T;t++) {
			// 초기 정보 입력 받고
			N = Integer.parseInt(bf.readLine());
			map = new int[N][N];
			gate = new ArrayList();
			person = new ArrayList();
			
			for(int i=0;i<N;i++) {
				String[] tmp = bf.readLine().split(" ");
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(tmp[j]);
					if(map[i][j] == 1)
						person.add(new int[] {i,j});
					else if(map[i][j] >1)
						gate.add(new int[] {i,j,map[i][j]});
				}
			}
			
			ans = Integer.MAX_VALUE;
			// 재귀적으로 부분집합 만들어 수행
			recursive(0, new int[person.size()]);
			
			// 정답 쌓기
			sb.append('#').append(t).append(' ').append(ans).append('\n');
			
		}
		// 정답 출력
		System.out.println(sb.toString());
	}

	/**
	 * 재귀적으로 부분집합 만들고
	 * 기저조건(= 모든 사람을 고려한 경우)을 만족하면
	 * 탈출 시뮬레이션을 수행하여 최소값(ans) 갱신
	 * @param cnt: 현재까지 고려한 사람 수
	 * @param selected: 사람마다 정해진 탈출 gate 인덱스 정보(selected)
	 */
	static void recursive(int cnt, int[] selected) {
		// 기저조건
		if(cnt == person.size()) {
			// 시뮬레이션
			int val = simulate(selected);
			// 갱신
			if(ans > val)
				ans = val;
			return;
		}
		
		// person[cnt]인 사람이 gate[0]을 선택한 것으로 다름 재귀 진행
		recursive(cnt+1, selected);
		selected[cnt] = 1;
		// person[cnt]인 사람이 gate[1]을 선택한 것으로 다름 재귀 진행
		recursive(cnt+1, selected);
		selected[cnt] = 0; // 이걸 빼먹음..
	}
	
	/**
	 * 사람마다 정해진 탈출 gate 인덱스 정보(selected)로 시뮬레이션을 했을 때
	 * 얻을 수 있는 비용을 반환하는 함수
	 * @param seleted: 사람마다 정해진 탈출 gate 인덱스 정보(selected)
	 * @return 비용 반환
	 */
	static int simulate(int[] seleted) {
		/**
		 * gp: 각 게이트별 탈출할 사람의 위치정보를 담은 변수
		 */
		ArrayList gp[] = new ArrayList[2];
		for(int i=0;i<seleted.length;i++)
		{
			int gNum = seleted[i];
			if(gp[gNum] == null)
				gp[gNum] = new ArrayList<int[]>();
			gp[gNum].add(person.get(i));
		}
		
		int reVal = 0;
		// 두 게이트에대해 탈출에 걸리는 비용 구하고
		// 더 큰 값을 얻는다.
		for(int i=0;i<2;i++) {
			if(gp[i] == null)
				continue;
			// 탈출 비용 계산
			int val = escape(gp[i], gate.get(i));
			if(reVal < val)
				reVal = val;
		}
		
		// 비용 반환
		return reVal;
	}
	
	/**
	 * 사람들이(gp) 게이트(g)를 탈출하는데 걸리는 비용 반환하는 함수
	 * @param gp: 사람들 위치 정보
	 * @param g: 게이트 위치 정보
	 * @return 비용 반환
	 */
	static int escape(ArrayList<int[]> gp, int[] g) {
		/**
		 * time: 사람마다 게이트에 도착하는 시간을 담은 변수
		 */
		int[] time = new int[gp.size()];
		for(int i=0;i<time.length;i++)
			for(int j=0;j<2;j++)
				time[i] += Math.abs(gp.get(i)[j] - g[j]);
		// 오름차순하여 먼저 도착하는 사람부터 고려
		Arrays.sort(time);
		int reVal= 0;
		
		// 게이트 이용 가능한 시간
		int[] eTime = new int[3];
		
		// 모든 사람이 탈출할 때까지
		for(int i=0;i<time.length;i++) {
			int minIdx = 0;
			// 게이트를 가장 빨리 이용가능한 시간을 구하고
			for(int j=1;j<3;j++)
				if(eTime[minIdx] > eTime[j])
					minIdx = j;
			// 그 시간보다 도착에 걸리는 시간이 짧다면 이미 기다리고 있던 것
			if(eTime[minIdx] > time[i])
				eTime[minIdx] += g[2];
			// 그 시간보다 도착에 걸리는 시간이 길다면 1초 기다리고 게이트 이용
			else
				eTime[minIdx] = time[i] + g[2] + 1;
			
		}
		
		// 가장 마지막까지 이용하는 시간을 구하고
		int maxIdx = 0;
		for(int j=1;j<3;j++)
			if(eTime[maxIdx] < eTime[j])
				maxIdx = j;
		reVal = eTime[maxIdx];
		
		// 디버깅에 사용한 필요 없는 코드..
//		if(g[2] == 2 && time.length == 7) {
//			maxIdx++;
//			
//		}
		
		return reVal;
	}
}
