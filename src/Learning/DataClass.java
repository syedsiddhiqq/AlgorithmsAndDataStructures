package Learning;

import java.util.Objects;

/**
 * @author Syed Ali.
 * @createdAt 01/11/2021, Monday, 10:46
 *
 *
 */
public class DataClass {
	private Integer id;
	private String name;

	public DataClass(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DataClass dataClass = (DataClass) o;
		return id.equals(dataClass.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
