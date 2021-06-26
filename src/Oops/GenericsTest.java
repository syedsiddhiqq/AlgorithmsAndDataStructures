package Oops;

/**
 * @author Syed Ali.
 * @createdAt 29/05/2021, Saturday, 15:04
 */
public class GenericsTest {


	public static void main(String[] args) {
		// instance of Integer type
		Test<Integer> iObj = new Test<Integer>(15);
		System.out.println(iObj.getObject());

		// instance of String type
		Test<String> sObj =
				new Test<String>("GeeksForGeeks");
		System.out.println(sObj.getObject());
	}

}
// A Simple Java program to show working of user defined
// Generic classes

// We use < > to specify Parameter type
class Test<Type> {
	// An object of type T is declared
	Type obj;

	Test(Type obj) {
		this.obj = obj;
	} // constructor

	public Type getObject() {
		return this.obj;
	}
}