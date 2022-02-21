package programmers;
/**
 * 2022.02.21
 * @author Chaerin Yu
 * https://programmers.co.kr/learn/courses/30/lessons/86491
 */
public class 최소직사각형 {

	public static void main(String[] args) {
		int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
		System.out.println(solution(sizes));
	}
    public static int solution(int[][] sizes) {
        // sizes 가로 세로 -> 가로>세로
        int wMax = 0, hMax = 0;
        for (int i = 0; i < sizes.length; i++) {
        	int temp = 0;
			if(sizes[i][0] < sizes[i][1]) {
				temp = sizes[i][0];
				sizes[i][0] = sizes[i][1];
				sizes[i][1] = temp;
			}
			
			if(wMax < sizes[i][0]) wMax = sizes[i][0];
			if(hMax < sizes[i][1]) hMax = sizes[i][1];
		}
        return wMax * hMax;
    }

}
