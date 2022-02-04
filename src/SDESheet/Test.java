package SDESheet;

/**
 * @author Syed Ali.
 * @createdAt 27/11/2021, Saturday, 14:33
 */
public class Test {
	public static void main(String[] args) {
		try{
			int x= 5/0;
			System.out.println(2323);
		}catch (ArithmeticException e){
			System.out.println(121);
		}
	}
}
