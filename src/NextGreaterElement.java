/**
 * @author Syed Ali.
 * @createdAt 10/01/2022, Monday, 14:52
 */
public class NextGreaterElement {

	private static void swap(char[] strArr, int i , int j){
		char temp  = strArr[i];
		strArr[i] = strArr[j];
		strArr[j] = temp;
	}

	private static void reverse(char[] strArr, int start, int end){
		while(start <= end){
			swap(strArr,start, end);
			start++;
			end--;
		}
	}

	private static int findNextNumber(int n){
		char[] strArr = String.valueOf(n).toCharArray(); //o(n)
		int lengthOfN = strArr.length;

		int i = lengthOfN - 1; // 5
		while(i - 1 >= 0 && strArr[i] <= strArr[i-1]){
			i--;
		}


		if(i == 0) return n;

		int pivot = i-1; // 1
		i = lengthOfN - 1;

		while(i > pivot && strArr[i] <= strArr[pivot]){
			i--;
		}
		swap(strArr,pivot,i); // pivot 1 , next gte 2 o (1)
		reverse(strArr, pivot+1, lengthOfN-1); //o (n/2)
		return Integer.parseInt(new String(strArr));
	}

	public static void main(String[] args) {
		System.out.println(findNextNumber(4321));
	}

}
