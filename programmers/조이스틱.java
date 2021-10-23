package programmers;

/**
 * 2021.10.23
 * @author Chaerin Yu
 * 조이스틱
 * https://programmers.co.kr/learn/courses/30/lessons/42860
 */
public class 조이스틱 {

	public static void main(String[] args) {
		System.out.println(solution("JEROEN"));
	}

    public static int solution(String name) {
    	int answer = 0;

        char[] c = name.toCharArray();
        int max = c.length - 1;
        int min = max;
        for (int i = 0; i < c.length; i++) {
            answer += Math.min(('Z' - c[i] + 1), (c[i] - 'A'));
            int right = i;
            int left = i;
            int next = (i + 1);
            while (next < c.length && c[next] == 'A') {
                next += 1;
            }

            int opposite = max - next + 1;

            min = Math.min( min, (right + opposite) + Math.min(left, opposite));
            // min = Math.min( min, (right + opposite + left));
        }

        return answer + min;
    	/*
        int answer = 0;
    	char[] arr = name.toCharArray();
    	int idx = 0;
    	int len = arr.length-1;
    	int min = len;
    	for (char c : arr) {
    		int fromA = c-'A';
    		int fromZ = 'Z'-c+1;
			if(fromA < fromZ) {
				answer += fromA;
			} else {
				answer += fromZ;
			}
			int right = idx, left = idx;
			int next = idx+1;
			while(next < arr.length && arr[next] == 'A') next += 1;
			int opposite = len-next+1;
			
			int temp = right + opposite + ((left>opposite) ? opposite : left);
			if(min>temp) min = temp; 
			idx++;
			System.out.println((c-'A')+", "+('Z'-c+1));
		}
        return answer+min;
        */
        
    }
    
}
