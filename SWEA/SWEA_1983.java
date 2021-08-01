package SWEA;
// #1983
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class SWEA_1983
{
    
	public static void main(String args[]) throws Exception
	{
        String[] grades = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
        
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(reader.readLine());
//        StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= tc; test_case++)
		{
            
			String[] input = reader.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
            int studentN = Integer.parseInt(input[1]);
            
            int[] sums = new int[N];
			for(int i=0; i<N; i++) {
                String[] scores = reader.readLine().split(" ");
                for(int s=0; s<3; s++) {
                    if(s == 0) {
                        sums[i] += Integer.parseInt(scores[s]) * 35;
                    } else if(s == 1) {
                        sums[i] += Integer.parseInt(scores[s]) * 45;
                    } else {
                        sums[i] += Integer.parseInt(scores[s]) * 20;
                    }
                }
            }
            
            
            int targetS = sums[studentN-1];
            int divisionN = N/10;
            int rank = 0;
            for(int i = 0; i < N ; i++) {
                if(targetS < sums[i]) {
                    rank += 1;
                }
            }
            
            int gradeRank = rank/divisionN;
            String ans = grades[gradeRank];
            System.out.println("#"+test_case+ " " + ans);
            
		}
	}
}