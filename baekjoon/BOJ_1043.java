package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1043 {

	static int N, M, knownNum, knownList2[]; // 사람 수, 파티 수, 진실을 아는 사람 수, 진실을 아는 사람 번호
	static ArrayList<ArrayList<Integer>> partyList; // 각 파티에 참여하는 사람
	
//	static Set<Integer> knownSet;
	static boolean[] knownList;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 사람 수
		M = Integer.parseInt(st.nextToken()); // 파티 수
		
		st = new StringTokenizer(br.readLine());
		knownNum = Integer.parseInt(st.nextToken()); // 진실을 아는 사람 수
		knownList = new boolean[51]; // 0~50
		for (int i = 0; i < knownNum; i++) {
			knownList[Integer.parseInt(st.nextToken())] = true; // 진실을 아는 사람 입력
		}
		
		// 아는 사람 없는 경우, 모든 파티에서 과장해서 이야기 해도 된다.
		if(knownNum == 0) {
			System.out.println(M);
			System.exit(0);
		}
		
		int res = M; // 파티 수
		
		partyList = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			partyList.add(new ArrayList<Integer>());
			st = new StringTokenizer(br.readLine());
			
			int partyNum = Integer.parseInt(st.nextToken());
			// 각 파티에 참여하는 사람 입력
			for (int j = 0; j < partyNum; j++) {
				int num = Integer.parseInt(st.nextToken());
				partyList.get(i).add(num);
			}
		}
		
		System.out.println(res);
		
		
	}

}
