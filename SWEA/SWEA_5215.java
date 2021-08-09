package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * [D3] 5215. 햄버거 다이어트
 */
public class SWEA_5215 {

	private static int totalScores = Integer.MIN_VALUE; // 최종 선택된 재료의 점수 합
	
	private static int N; // 재료의 수
	private static int L; // 제한 칼로리
	private static ArrayList<Ingredient> ingredients; // 재료
	
	private static int chosenCalrories = 0; // 선택된 칼로리 총 합
	private static int chosenScores = 0; // 선택된 재료 점수 총 합
	
	// 재료 고르기
	private static void choose(int index) {
		// 모든 재료들 다 돌아보고 난 뒤, 칼로리와 점수 합을 확인해본다.
		if(N == index) {
			// 선택된 재료의 총 합 칼로리가 제한된 칼로리보다 작거나 같고
			// 점수 합이 제일 높은 재료들을 고른다.
			if(chosenCalrories <= L && totalScores <= chosenScores) {
				totalScores = chosenScores;
			}
			return ;
		}
		
		Ingredient in = ingredients.get(index);
		// 해당 재료를 선택했을 때
		chosenCalrories += in.calories;
		chosenScores += in.scores;
		choose(index+1);
		
		// 해당 재료를 선택안했을 때
		chosenCalrories -= in.calories;
		chosenScores -= in.scores;
		choose(index+1);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // test case
		
		StringTokenizer st = null;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 재료의 수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리
			
			ingredients = new ArrayList<Ingredient>();
			// 제한 칼로리보단 적으면서 제일 맛있는 재료를 찾는다.
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				ingredients.add(new Ingredient(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			// 선택한 재료(칼로리, 점수) 초기화
			// 선택한 재료의 최대 점수 초기화
			chosenCalrories = 0; chosenScores = 0;
			totalScores = Integer.MIN_VALUE;
			choose(0);
			
			System.out.println("#"+tc+" "+totalScores);
		}
	}

}
// 재료
class Ingredient {
	int scores; // 점수
	int calories; // 칼로리
	
	public Ingredient() {}
	
	public Ingredient(int scores, int calories) {
		super();
		this.scores = scores;
		this.calories = calories;
	}
	
}