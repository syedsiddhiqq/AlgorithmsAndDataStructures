package Learning;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

/**
 * @author Syed Ali.
 * @createdAt 08/09/2021, Wednesday, 16:48
 */
public class MainTest {

	public static void main(String[] args) {
//		Queue<Integer> q = new LinkedList<>();
//		Random random = new Random();
//		List<Integer> l = new ArrayList<>();
//		RequestClass requestClass = new RequestClass();
//		requestClass.setValue(null);
//
//		ResponseClass responseClass = new ResponseClass();
//		responseClass.setInput(requestClass.getValue());
//
//		System.out.println(responseClass.getInput());

//		EnumLearning enumLearning =  new EnumLearning();
//		enumLearning.setTypes(Types.NEW);
//		System.out.println(enumLearning.getTypes());

		Set<DataClass> datas =  new HashSet<>();
		datas.add(new DataClass(1,"syed"));
		datas.add(new DataClass(2,"syed"));
		System.out.println(datas.size());
	}
}
