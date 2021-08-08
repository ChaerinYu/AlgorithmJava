package baekjoon;
/*
 * 10171. 강아지
 * 세가지 표현 모두 줄바꿈을 나타내지만,
	시스템에 따라서 사용하는 개행문자가 다릅니다.
	\n - unix
	\r - mac
	\r\n - windows
	따라서, 한가지를 사용하면 시스템에 따라서 줄바꿈이 되지 않을 수도 있습니다.
 */
public class BOJ_10172 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("|\\_/|\n" + 
				"|q p|   /}\n" + 
				"( 0 )\"\"\"\\\n" + 
				"|\"^\"`    |\n" + 
				"||_/=\\\\__|\n");
		System.out.println(sb);
	}

}