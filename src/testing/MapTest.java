package testing;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Syed Ali.
 * @createdAt 18/10/2021, Monday, 09:52
 */
public class MapTest {

	public static class Temp{
		public Integer i;

		public Integer getI() {
			return i;
		}

		public void setI(Integer i) {
			this.i = i;
		}
	}

	public static void main(String[] args) {
		Map<String,Object> d = new HashMap<>();
		d.put("q",2);
		Temp t = new Temp();
		t.setI(Integer.valueOf((String)d.get("q")));
		System.out.println(t.getI());
	}
}
