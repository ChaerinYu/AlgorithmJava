package programmers;

import java.util.Stack;

public class 짝지어_제거하기 {

	class Solution
	{
	    public int solution(String s)
	    {
//	        int answer = 0;
	        Stack<Character> stack = new Stack<Character>();
	        char[] arr = s.toCharArray();
	        stack.push(arr[0]);
	        char temp;
	    	for (int i = 1; i < arr.length; i++) {
	            if(stack.size()==0) {
	                stack.push(arr[i]);
	                continue;
	            }
	    		temp = stack.peek();
	    		if(arr[i]==temp) {
	    			stack.pop();
	    			continue;
	    		}
	    		else stack.push(arr[i]);
	    	}
	    	if(stack.size()!=0) return 0;
	    	else return 1;
	        
	        // return answer;
	    }
	}
}
/**

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(stack.size() == 0){
                stack.push(c);
            }
            else if(stack.peek() == c){
                stack.pop();
            }
            else{
                stack.push(c);
            }
        }


        return stack.size() > 0 ? 0 : 1;
    }
}


**/