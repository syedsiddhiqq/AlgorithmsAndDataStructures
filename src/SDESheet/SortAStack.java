package SDESheet;

import java.util.Stack;

/**
 * @author Syed Ali.
 * @createdAt 11/12/2021, Saturday, 00:05
 */
public class SortAStack {

	private static void sortStack(Stack<Integer> input){
		Stack<Integer> temp = new Stack<>();
		while(!input.isEmpty()){
			int top = input.pop();
			while(!temp.isEmpty() && top < temp.peek()){
				input.add(temp.pop());
			}
			temp.add(top);
		}

		while(!temp.isEmpty()){
			input.add(temp.pop());
		}
	}

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		st.push(8);
		st.push(1);
		st.push(4);
		st.push(2);
		st.push(7);
		st.push(11);
		st.push(2);

		sortStack(st);

		while (!st.isEmpty()){
			System.out.println(st.pop());
		}
	}
}
