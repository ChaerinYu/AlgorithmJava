package test;

import java.util.Stack;

public class Test2 {

	public static void main(String[] args) {
		solution("i love coding", "mode", new int[]{0, 10});
		solution("i love coding", "mask", new int[]{0, 0, 3, 2, 3, 4});
		solution("abcde fghi", "axyz", new int[]{3, 9, 0, 1});
	}

	private static void solution(String sentence, String keyword, int[] skips) {
		Stack<Character> stack = new Stack<Character>();
		char[] arr = sentence.toCharArray();
		char[] maskArr = keyword.toCharArray();
		
		int idx = 0;
		for (int i = 0; i < arr.length ; ) {
			
			// keyword 입력하기
			if(idx < skips.length && 0 == skips[idx]) {
				stack.push(maskArr[idx % maskArr.length]);
				idx++;
			}
			// sentence입력
			else {
				if(idx < skips.length) skips[idx]--;
				// 중복되는 문자
				if(skips.length > idx && arr[i] == maskArr[idx % maskArr.length]) {
					stack.push(maskArr[idx % maskArr.length]);
					idx++;
				}
				stack.push(arr[i]);
				i++;
			}
		}
		
		if(idx < skips.length) {
			while(skips[idx] == 0) {
				stack.push(maskArr[idx % maskArr.length]);
				idx++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(stack.size() > 0) {
			sb.append(stack.pop());
		}
		System.out.println(sb.reverse().toString());
	}
}
