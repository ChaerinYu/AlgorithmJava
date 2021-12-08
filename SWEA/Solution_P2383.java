package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution_P2383 {
	static int N, map[][], ans;
	static ArrayList<int[]> gate, person;

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("sample_input_2383.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		
		for(int t=1;t<=T;t++) {
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
			recursive(0, new int[person.size()]);
			
			sb.append('#').append(t).append(' ').append(ans).append('\n');
			
		}
		System.out.println(sb.toString());
	}

	// 중복 순열
	static void recursive(int cnt, int[] selected) {
		if(cnt == person.size()) {
			int val = simulate(selected);
			// 최소시간
			if(ans > val)
				ans = val;
			return;
		}
		
		recursive(cnt+1, selected);
		selected[cnt] = 1;
		recursive(cnt+1, selected);
		selected[cnt] = 0; // 이걸 빼먹음..
	}
	
	static int simulate(int[] seleted) {
		// 계단1, 계단2
		ArrayList gp[] = new ArrayList[2];
		// 계단별 사람 위치 입력
		for(int i=0;i<seleted.length;i++)
		{
			int gNum = seleted[i];
			if(gp[gNum] == null)
				gp[gNum] = new ArrayList<int[]>();
			gp[gNum].add(person.get(i));
		}
		
		int reVal = 0;
		for(int i=0;i<2;i++) {
			if(gp[i] == null)
				continue;
			// 각 계단 탈출시 소요 시간
			int val = escape(gp[i], gate.get(i));
			// 계단 탈출 오래 걸린 걸 값으로 return해줘야 한다. (해당 순열로 최종 걸린 시간)
			if(reVal < val)
				reVal = val;
		}
		
		return reVal;
	}
	
	static int escape(ArrayList<int[]> gp, int[] g) {
		int[] time = new int[gp.size()];
		for(int i=0;i<time.length;i++)
			// 계단과 사람거리 계산
			for(int j=0;j<2;j++)
				time[i] += Math.abs(gp.get(i)[j] - g[j]);
		Arrays.sort(time);
		int reVal= 0;
		
		// 한 계단에 한 번에 최대 3명만 수용가능
		int[] eTime = new int[3];
		
		
		for(int i=0;i<time.length;i++) {
			int minIdx = 0;
			for(int j=1;j<3;j++)
				if(eTime[minIdx] > eTime[j])
					minIdx = j;
			if(eTime[minIdx] > time[i])
				eTime[minIdx] += g[2];
			else
				eTime[minIdx] = time[i] + g[2] + 1;
			
		}
		
		int maxIdx = 0;
		for(int j=1;j<3;j++)
			if(eTime[maxIdx] < eTime[j])
				maxIdx = j;
		reVal = eTime[maxIdx];
		
		
		if(g[2] == 2 && time.length == 7) {
			maxIdx++;
			
		}
		
		return reVal;
	}
}
