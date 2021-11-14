package programmers;

public class 행렬의_곱셈 {

	public static void main(String[] args) {
		int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
		int[][] arr2 = {{3, 3}, {3, 3}};
		System.out.println(solution(arr1, arr2));
	}

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2[0].length; j++) {
				for (int k = 0; k < arr2.length; k++) {
					answer[i][j] += arr1[i][k]*arr2[k][j];
				}
//				for (int m = 0; m < arr1[i].length; m++) {
//					for (int n = 0; n < arr2.length; n++) {
//						answer[i][j] += arr1[m][n]*arr2[n][j];
//					}
//				}
				
//				answer[i][j] = arr1[i][j] * arr2[i][j];
				System.out.print(answer[i][j]+" ");
			}
			System.out.println();
		}
        return answer;
    }
}
