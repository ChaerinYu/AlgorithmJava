package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
/**
 * 1931. 회의실 배정
 * @author Chaerin Yu
 * 2021.11.07
 */
public class BOJ_1931 {

	static int N; // 회의 수
	static int[][] meetings; // 회의
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine()); // 회의 수
		meetings = new int[N][2];
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			meetings[i][0] = start;
			meetings[i][1] = end;
		}
		
		Arrays.sort(meetings, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// 끝나는 시간이 같은 경우, 시작시간 빠른 순서부터
				if(o1[1]==o2[1]) return o1[0]-o2[0];
				else {
					// 끝나는 시간 다른 경우, 끝나는시간 빠른 순서부터
					return o1[1]-o2[1];
				}
//				if(o1[0]==o2[0]) return o1[1]-o2[1];
//				return o1[1]-o2[0];
			}
			
		});
		
		List<int[]> list = new ArrayList<int[]>();
		list.add(meetings[0]);
		
		for (int i = 1; i < N; i++) {
			if(meetings[i][0] >= list.get(list.size()-1)[1]) {
				list.add(meetings[i]);
			}
		}
		
		System.out.println(list.size());
	}

}
