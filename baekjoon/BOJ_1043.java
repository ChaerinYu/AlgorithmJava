package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * 1043. 거짓말
 * @author Chaerin Yu
 * union-find
 */
public class BOJ_1043 {

	static final int NUM = 50;
	
	static int N, M, knownNum; // 사람 수, 파티 수, 진실을 아는 사람 수
	static ArrayList<ArrayList<Integer>> partyList; // 각 파티에 참여하는 사람
	static boolean[] knownList; // 진실을 아는 사람
	static int[] parents; // 부모 (파티 대표)
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 사람 수
		M = Integer.parseInt(st.nextToken()); // 파티 수
		
		st = new StringTokenizer(br.readLine());
		knownNum = Integer.parseInt(st.nextToken()); // 진실을 아는 사람 수
		knownList = new boolean[NUM+1]; // 0~50
		for (int i = 0; i < knownNum; i++) {
			knownList[Integer.parseInt(st.nextToken())] = true; // 진실을 아는 사람 입력
		}
		
		// 아는 사람 없는 경우, 모든 파티에서 과장해서 이야기 해도 된다.
		if(knownNum == 0) {
			System.out.println(M);
			System.exit(0);
		}
		
		make();
		
		partyList = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			partyList.add(new ArrayList<Integer>());
			st = new StringTokenizer(br.readLine());
			
			int partyNum = Integer.parseInt(st.nextToken());
			int first = 0;
			if(partyNum > 0) {
				first = Integer.parseInt(st.nextToken());
				partyList.get(i).add(first);
			}
			// 각 파티에 참여하는 사람 입력
			for (int j = 1; j < partyNum; j++) {
				int num = Integer.parseInt(st.nextToken());
				partyList.get(i).add(num);
				union(first, num);
//				first = num;
			}
		}
		
		// 부모(파티 대표)도 체크한다.
		for (int i = 1; i <= NUM; i++) {
			if(knownList[i]) {
				knownList[find(i)] = true;
			}
		}
		
		int res = M; // 파티 수
		for (ArrayList<Integer> party : partyList) {
			if(party.size()>0) {
				if(knownList[find(party.get(0))]) res--;
			}
		}
		
		System.out.println(res);
		
		
	}

	// 부모 만들기
	private static void make() {
		parents = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	// 대표 찾기
	private static int find(int a) {
		if(a==parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	// 무리 합치기 => 동일 대표
	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return;
		// 정렬못하니까 union할 때 정렬해줌!
		if(aRoot < bRoot)
			parents[bRoot] = aRoot;
		else 
			parents[aRoot] = bRoot;
	}

}
