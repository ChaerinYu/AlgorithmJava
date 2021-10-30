package test;

public class 프로그래밍2 {
	
	public static void main(String[] args) {
		System.out.println(solution(5, 3));
	}

    public static int[] solution(int n, int jump) {
        int[] answer = {};
        
        int[][] map = new int[n+1][n+1];
        
        int r = 1, c = 1; // 시작점
        int num = 1;
        int temp = n;
        while(num != n*n) {
        	for (int i = 1; i <= n; i ++) {
        		c += jump;
        		if(c > n) break;
        		map[r][c] = num++; 
			}
        	temp--;
        	if(num == n*n) {
        		answer = new int[] {r, c};
        		break;
        	}
        	for (int i = 1; i <= n; i ++) {
        		r += jump;
        		if(r > n) break;
				map[r][c] = num++;
			}
        	if(num == n*n) {
        		answer = new int[] {r, c};
        		break;
        	}
        	jump *= -1;
        }
        
        return answer;
    }

}
