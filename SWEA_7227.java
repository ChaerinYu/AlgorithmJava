package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * DFS 
 * 지렁이 절반이 선택되었다고 하면
 * 선택된 지렁이들은 선택되지 않은 지렁이들에게 가므로 선택된 지렁이들의 좌표는 더해주고 
 * 선택받지 못한 지렁이들 값은 빼주면 벡터 합을 구할 수 있다.
 * 최대 값은 80,000,000,000 으로 int 형의 최대 값을 벗어나므로 long 형으로 사용한다.
 * 
 * 짝을 지어주는 모든 경우를 고해서 백터 전체 합이 최소인 경우를 출력한다.
 * 벡터상의 출발 위치 지렁이의 지표 합 - 벡터상의 도착 위치 지렁이의 지표 합 = 벡터 전체 합 
 * 출발 위치 지렁이끼리 변경되더라도 지렁이의 벡터 전체 합 항상 동일 (도착 위치 지렁이 또한 동일) 
 * -> 출발 위치 지렁이 / 도착 위치 지렁이 나누는 문제 => 벡터 전체 최소 합인 출발(또는 도착) 위치에 올 수 있는 지렁이 N/2 구하기 
 */
public class SWEA_7227 {
	static int wormNum = 0; // 지렁이 수 
	static int[][] worm; // 지렁이 좌표 
	static int[] matched; // 선택 여부 (matching 여부)
	
    static long min;
	
	public static void main(String args[]) throws Exception
	{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(reader.readLine());

		for(int test_case = 1; test_case <= tc; test_case++)
		{
			min = Long.MAX_VALUE;
			
            wormNum = Integer.parseInt(reader.readLine());
            worm = new int[wormNum][2];
            matched = new int[wormNum];
            
            for(int i=0; i<wormNum; i++) {
            	String[] input = reader.readLine().split(" ");
    			worm[i][0] = Integer.parseInt(input[0]);
    			worm[i][1] = Integer.parseInt(input[1]);
            }
            
            wormMatch(0, 0);
            
            System.out.println("#"+test_case+ " " + min);
            
		}
	}
	
	// 재귀 호출
	// parameter: 매칭된 지렁이 쌍, 비교 시작점(index)
	private static void wormMatch(int pairNum, int compareStart) {

        
        if(pairNum == wormNum / 2) {
        	long dx = 0, dy = 0;
        	for(int i=0; i<wormNum; i++) {
        		if(matched[i] > 0) {
        			dx += worm[i][0];
        			dy += worm[i][1];
        		} else {
        			dx -= worm[i][0];
        			dy -= worm[i][1];
        		}
        	}
        	long dist =  (long) (Math.pow(dx, 2) + Math.pow(dy, 2));
        	if(min > dist) {
        		min = dist;
        		return;
        	}
        }
        
        for(int i=compareStart; i<wormNum; i++ ) {
//        	if(matched[i] != 1) { //이미 짝이 있는 지렁이는 패스
            	matched[i] = 1;
            	wormMatch(pairNum + 1, i+1);
            	matched[i] = 0;
//        	}
        }
	}
}
