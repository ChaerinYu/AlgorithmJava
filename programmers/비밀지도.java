package programmers;

import java.util.Arrays;

/**
 * 2021.10.19
 * 비밀지도
 * @author Chaerin Yu
 * https://programmers.co.kr/learn/courses/30/lessons/17681
 * String.format
 */
public class 비밀지도 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28})));
	}

    public static String[] solution(int n, int[] arr1, int[] arr2) {
    	
    	char[][] map1 = changeTwoArray(n, arr1);
    	char[][] map2 = changeTwoArray(n, arr2);
    	
    	char[][] newMap = new char[n][n];
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < n; j++) {
				newMap[i][j] = (char) (map1[i][j] | map2[i][j]);
			}
		}
    	
    	String[] answer = new String[n];
    	for (int i = 0; i < n; i++) {
    		StringBuilder temp = new StringBuilder();
    		for (int j = 0; j < n; j++) {
    			// 1일 때에는 #
				if(newMap[i][j]=='1') {
					temp.append("#");
				} else {
					temp.append(" ");
				}
			}
    		answer[i] = temp.toString();
//    		System.out.println(temp);
		}
    	
        return answer;
    }
    
    // 2차 char 배열로 변경
    private static char[][] changeTwoArray(int n, int[] arr) {

    	char[][] map = new char[n][n];
    	for (int i = 0; i < arr.length; i++) {
			
    		String temp = "";
    		while(arr[i]>0) {
    			temp = (arr[i]%2) + temp;
    			arr[i] = arr[i]/2;
    		}
    		
//    		temp = String.format("%0"+n+"d", Integer.parseInt(temp)); // 런타임에러발생 (숫자 범위 초과 문제 인 듯..)
    		temp = String.format("%"+n+"s", temp); // 0말고 그냥 빈칸으로 해준다. 
    		map[i] = temp.toCharArray();
//    		System.out.println(Arrays.toString(map[i]));
		}
    	return map;
    }
}
