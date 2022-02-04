package SDESheet;

/**
 * @author Syed Ali.
 * @createdAt 10/12/2021, Friday, 18:14
 */
public class StackUsingArrays {

	private static int[] arr = new int[100];

	private static int currIndex = 0;

	private static void push(int i){
		arr[currIndex] = i;
		currIndex++;
	}

	private static void pop(){
		arr[--currIndex] = Integer.MIN_VALUE;
	}

	private static void print(){
		for(int i=0;i<currIndex;i++){
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {
		push(5);
		push(1);
		push(4);
		push(5);

		pop();
		pop();

		push(1212);
		push(112);

		print();
	}
}
