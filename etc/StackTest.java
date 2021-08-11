package etc;

public class StackTest {

	public static void main(String[] args) {
		Stack stack = new Stack();
		System.out.println(stack.isEmpty());
		stack.push("악뮤");
		System.out.println(stack);
		stack.push("아이유");
		System.out.println(stack);
		stack.push("김재환");
		System.out.println(stack);
		System.out.println(stack.isEmpty());
		
		System.out.println(stack.peek());
		System.out.println(stack);
		
		System.out.println(stack.pop());
		System.out.println(stack);
		
		System.out.println(stack.pop());
		System.out.println(stack);
		
		System.out.println(stack.pop());
		System.out.println(stack);
	}

}
