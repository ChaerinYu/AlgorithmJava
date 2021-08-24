package etc;
/**
 * 정사각형 크기로 각각 색상 몇 개 있는지 세기
 * @author user
 * divide and conquer
 */
public class MakeSpaceTest {

	static int white, green;
	static int[][] spaces;
	
	public static void main(String[] args) {
		int n = 8;
		spaces = new int[][] {
			{1,1,0,0,0,0,1,1},
			{1,1,0,0,0,0,1,1},
			{0,0,0,0,1,1,0,0},
			{0,0,0,0,1,1,0,0},
			{1,0,0,0,1,1,1,1},
			{0,1,0,0,1,1,1,1},
			{0,0,1,1,1,1,1,1},
			{0,0,1,1,1,1,1,1}
		};
		
		// 전체 공간을 하나의 사각형으로 보기 때문에 0, 0, n을 넘겨준다.
		cut(0, 0, n);
		System.out.println(white);
		System.out.println(green);
	}
	
	// 멤버변수라서 배열을 파라미터로 줄 필요 없음
	// 잘라진 배열이 아니라 논리적으로 배열을 처리하기 위해 index를 넘겨준다.
	private static void cut(int r, int c, int size) {
		
		int sum = 0;
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				sum += spaces[i][j];
			}
		}
		
		// 같은 색인지 체크
		if(sum == size*size) {
			// 초록색
			green++;
		} else if(sum == 0) {
			// 하얀색
			white++;
		} else {
			// 유도 파트
			// 색이 섞여 있음
			// 4분할 하여 각각의 사각형 처리한다.
			int half = size/2;
			
			cut(r, c, half); // 2사분면
			cut(r, c+half, half); // 1사분면
			cut(r+half, c, half); // 3사분면
			cut(r+half, c+half, half); // 4사분면
			
		}
		
		// 같은 색이라면 더이상 재귀를 안타도 되기 때문에
		// 초록/하얀색만 있는 경우가 기저 조건이 된다.
		return; 
	}
}
